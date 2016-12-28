package com.ts;

import com.jcraft.jsch.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by agosipov on 21.09.2016.
 */
public class Host {
    private String path;
    private String logpath;
    private List<String> logname;
    private int CPU;
    private double FreeSpace;
    private String Hostname;
    private String Login;
    private String Password;

    Host(String Cred, String logpath, List<String> logname, double FreeSpace){
        String[] ret = ParseCred(Cred);
        this.Hostname = ret[1];
        this.Login    = ret[0];
        this.Password = ret[2];
        this.CPU      = Integer.parseInt(ret[3]);
        this.path = "/home/" + this.Login + "/influx_monitoring/";
        this.logpath = logpath;
        this.FreeSpace = FreeSpace;
        this.logname = logname;
    }

    private static String[] ParseCred(String Cred){
        String[] ret = new String[4];
        ret[0] = Cred.trim().split("@")[0];
        ret[1] = Cred.trim().split("@")[1].split(":")[0];
        ret[2] = Cred.trim().split("@")[1].split(":")[1];
        ret[3] = Cred.trim().split("@")[1].split(":")[2].replace("CPU=", "");
        return ret;
    }

    public String getHostname(){
        return this.Hostname;
    }

    public String getShortHostname(){
        String ret = this.Hostname.replace("k10-fico-", "");
        ret = ret.replace(".vtb24.ru", "");
        return ret;
    }

    public List<String> runBashCommand(String command) {
        List<String> result = new ArrayList<>();
        //String result = "";
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(this.Login, this.Hostname, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(this.Password);
            session.connect();

            ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
            InputStream in = channelExec.getInputStream();
            channelExec.setCommand(command);
            channelExec.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = reader.readLine()) != null)
            {
                result.add(line);
            }

            int exitStatus = channelExec.getExitStatus();
            channelExec.disconnect();
            session.disconnect();

            /*if(exitStatus < 0){
                System.out.println("Done, but exit status not set!");
            }
            else if(exitStatus > 0){
                System.out.println("Done, but with error!" + "err = " + exitStatus);
            }
            else{
                System.out.println("Done!");
            }*/

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return result;
    }

    private String getPidFromString(String in) {
        in = in.replaceAll("\\s{2}"," ");
        String[] ret = in.trim().split(" ");
        if(ret.length >= 2) return in.trim().split(" ")[1];
        else return "";
    }

    public void StartScript(String script){
        if(CheckScript(script, 0)) {
            if (CheckStatus(script, 0) == 0) {
                String command = "nohup " + this.path + script + " </dev/null >/dev/null 2>&1 &";
                runBashCommand(command);
                System.out.println(script + " script has been launched on " + this.Hostname);
            } else System.out.println(script + " script has been already launched on " + this.Hostname);
        }else System.out.println(script + " not found on " + this.Hostname);
    }

    //i=0 for silent mode
    public int CheckStatus(String script, int i){
        int status = Integer.parseInt(runBashCommand("ps -ef | grep -v grep | grep -c " + script).get(0));
        if (i != 0){
            if(status == 0) System.out.println(script + " is not launched on " + this.Hostname);
            else System.out.println(script + " is launched on " + this.Hostname);
        }
        return status;
    }

    public void StopScript(String script){
        if(CheckStatus(script, 0) == 0) System.out.println(script + " is not launched on " + this.Hostname);
        else{
            List<String> ret = runBashCommand("ps -ef | grep " + script);
            int counter = 0;
            for(int i = 0; i < ret.size(); i++){
                if (!ret.get(i).contains("grep")) {
                    String pid = getPidFromString(ret.get(i));
                    if (pid != "") {
                        runBashCommand("kill -USR2 " + pid);
                        counter++;
                    }
                }
            }
            if(counter == 1) System.out.println(counter + " instance of " + script + " script has been stopped on " + this.Hostname);
            if(counter > 1)  System.out.println(counter + " instances of " + script + " script have been stopped on " + this.Hostname);
        }
    }

    //i=0 for silent mode
    public boolean CheckScript(String script, int i){
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(this.Login, this.Hostname, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(this.Password);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            String currentDirectory=sftpChannel.pwd();
            SftpATTRS attrs=null;
            try {
                attrs = sftpChannel.stat(this.path + "/" + script);
            } catch (Exception e) {
                session.disconnect();
                sftpChannel.disconnect();
                if(i != 0) System.out.println(script + " not found on " + this.Hostname);
                return false;
            }
            if(i != 0) System.out.println(script + " is installed " + this.Hostname);
            session.disconnect();
            sftpChannel.disconnect();
            return true;
        }catch(JSchException e){
            if(i != 0) System.err.println("Error: " + e);
            return false;
        }catch(SftpException e){
            if(i != 0) System.err.println("Error: " + e);
            return false;
        }
    }

    public void FileManagement(String file, String action){
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(this.Login, this.Hostname, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(this.Password);
            session.connect();

            ChannelSftp sftpChannel = (ChannelSftp)session.openChannel("sftp");
            sftpChannel.connect();

            if (action.equals("script")) {
                if(!CheckScript(file, 0)) {
                    sftpChannel.cd("/home/" + this.Login);
                    try {
                        sftpChannel.cd("influx_monitoring");
                    } catch (SftpException e) {
                        sftpChannel.mkdir("influx_monitoring");
                        sftpChannel.cd("influx_monitoring");
                    }

                    File f = new File(file);
                    if (f.isFile()) sftpChannel.put(new FileInputStream(f), f.getName());
                    runBashCommand("chmod ugo+rwx " + this.path + file);
                    System.out.println(file + " has been deployed on " + this.Hostname);
                }else System.out.println(file + " has been already deployed on " + this.Hostname);
            }

            if(action.equals("logs")){
                String serverName = this.Hostname.substring(this.Hostname.indexOf("k10-fico-") + 9, this.Hostname.indexOf(".vtb24", this.Hostname.indexOf("k10-fico-")));
                logpath = logpath.replace("{wps_server}", serverName);
                logpath = logpath.replace("{number}", serverName.split("0")[1]);
                System.out.println(logpath);
                sftpChannel.cd(logpath);
                byte[] buffer = new byte[1024];
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
                File logDir = new File("logs-" + timeStamp);
                if(!logDir.isDirectory()){
                    try{
                        logDir.mkdir();
                    }catch(SecurityException e){
                        System.err.println("Error: " + e);
                    }
                }
                for(String log: logname) {
                    BufferedInputStream bis = new BufferedInputStream(sftpChannel.get(log));
                    File newFile = new File("logs-" + timeStamp + "/" + log.split("\\.")[0] + "_" + serverName + ".log");
                    OutputStream os = new FileOutputStream(newFile);
                    BufferedOutputStream bos = new BufferedOutputStream(os);
                    int readCount;
                    while ((readCount = bis.read(buffer)) > 0) {
                        bos.write(buffer, 0, readCount);
                    }
                    bis.close();
                    bos.close();
                }
                System.out.println(this.Hostname + " logs has been downloaded");
            }

            session.disconnect();
            sftpChannel.disconnect();

        }catch(Exception e){
            System.err.println("Error: " + e);
            System.exit(-1);
        }
    }
    public void scriptRemoving(){
        runBashCommand("rm -fr " + "/home/" + this.Login + "/influx_monitoring");
        System.out.println("Scripts have been deleted on " + this.Hostname);
    }

    public void ServerCheck(){
        List<String> res = runBashCommand("lsdev -Cc processor");
        int CPU = 0;
        for(String line: res){
            if(line.contains("Processor")) CPU++;
        }
        res = runBashCommand("df -g /opt/");
        String[] ret = null;
        res.set(1, res.get(1).replaceAll(" +", " "));
        if(res.size() > 1) ret = res.get(1).split(" ");
        String Mem = ret[2];
        String[] Core = {"Cores", "Cores"};
        if(CPU==1) Core[0] = "Core";
        if(this.CPU == 1) Core[1] = "Core";
        String pass = "OK";
        if (CPU != this.CPU && Float.parseFloat(Mem) >= this.FreeSpace) pass = "FAIL (should be "+ this.CPU + " " + Core[1] +")";
        if (CPU == this.CPU && Float.parseFloat(Mem) <= this.FreeSpace) pass = "FAIL (free space less than " + this.FreeSpace+ "Gb)";
        if (CPU != this.CPU && Float.parseFloat(Mem) <= this.FreeSpace) pass = "FAIL (free space less than " + this.FreeSpace+ "Gb and should be "+ this.CPU + " " + Core[1] + ")";

        System.out.println(this.getShortHostname() + " has " + CPU + " "+ Core[0] + " and " + Mem + "Gb free space" + "\t" + pass);
    }
}
