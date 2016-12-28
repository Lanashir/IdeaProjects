package com.ts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by agosipov on 21.09.2016.
 */
public class ServerList {

    private List<Host> List = new ArrayList<>();
    private String logpath = "";
    private List<String> logname = new ArrayList<>();
    private double FreeSpace = 0.0;

    ServerList(String ServerListFile){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(ServerListFile));
            String line;
            while ((line = reader.readLine()) != null){
                if(line.contains("log_path")) this.logpath = line.replace("log_path = ", "");
                if(line.contains("free_space")) this.FreeSpace = Float.parseFloat(line.replace("free_space = ", ""));
                if(line.contains("log_name")) this.logname.add(line.replace("log_name = ", ""));

                if(line.contains("server = ")) List.add(new Host(line.replace("server = ", ""), logpath, logname, FreeSpace));
            }

        }catch(FileNotFoundException e){
            System.out.println(ServerListFile + " has been missed");
            System.exit(1);
        }catch(IOException e){
            System.out.println("Can't read " + ServerListFile);
            System.exit(1);
        }
    }
    public List<Host> getList(){
        return this.List;
    }

    public List<Host> getWps(){
        List<Host> Wps = new ArrayList<>();
        List.forEach((host) -> {
            if(host.getHostname().contains("wps")) Wps.add(host);});
        return Wps;
    }
}
