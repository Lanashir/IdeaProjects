package com.ts;

public class Main {
    static final String Iostat = "iostat-influx.pl";
    static final String Vmstat = "vmstat-influx.pl";
    static final String ServerListFile = "server-list.txt";

    /*TODO
    */
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Command is invalid, try -help for info.");
            System.exit(0);
        }else {
            CommandList currCommand = CommandList.getByCommand(args[0]);

            if (currCommand == null) {
                System.out.println("Command is invalid, try -help for info.");
                System.exit(0);
            }

            ServerList serverList = new ServerList(ServerListFile);

            switch (currCommand) {
                case START:
                    serverList.getList().forEach((host) -> {
                        new RunHostProcedure(host) {
                            public void run() {
                                host.StartScript(Iostat);
                                host.StartScript(Vmstat);
                            }
                        }.start();
                    });
                    break;
                case STATUS:
                    serverList.getList().forEach((host) -> {
                        new RunHostProcedure(host) {
                            public void run() {
                                host.CheckStatus(Iostat, 1);
                                host.CheckStatus(Vmstat, 1);
                            }
                        }.start();
                    });
                    break;
                case STOP:
                    serverList.getList().forEach((host) -> {
                        new RunHostProcedure(host) {
                            public void run() {
                                host.StopScript(Iostat);
                                host.StopScript(Vmstat);
                            }
                        }.start();
                    });
                    break;
                case HELP:
                    System.out.println("\t -deploy \t deploying scripts on servers listed in server-list.txt");
                    System.out.println("\t -delete \t deleting scripts on servers listed in server-list.txt");
                    System.out.println("\t -start  \t starting scripts on servers listed in server-list.txt");
                    System.out.println("\t -status \t checking scripts status on servers listed in server-list.txt");
                    System.out.println("\t -stop   \t stopping scripts on servers listed in server-list.txt");
                    System.out.println("\t -logs   \t downloading logs from wps servers");
                    break;
                case FIND:
                    serverList.getList().forEach((host) -> {
                        new RunHostProcedure(host) {
                            public void run() {
                                host.CheckScript(Iostat, 1);
                                host.CheckScript(Vmstat, 1);
                            }
                        }.start();
                    });
                    break;
                case LOGS:
                    serverList.getWps().forEach((host) -> {
                        new RunHostProcedure(host) {
                            public void run() {
                                host.FileManagement("", "logs");
                            }
                        }.start();
                    });
                    break;
                case DEPLOY:
                    serverList.getList().forEach((host) -> {
                        new RunHostProcedure(host) {
                            public void run() {
                                host.FileManagement(Vmstat, "script");
                                host.FileManagement(Iostat, "script");
                            }
                        }.start();
                    });
                    break;
                case DELETE:
                    serverList.getList().forEach((host) -> {
                        new RunHostProcedure(host) {
                            public void run() {
                                host.StopScript(Iostat);
                                host.StopScript(Vmstat);
                                host.scriptRemoving();
                            }
                        }.start();
                    });
                    break;
                case CHECK:
                    serverList.getList().forEach((host) -> {
                        new RunHostProcedure(host) {
                            public void run() {
                                host.ServerCheck();
                            }
                        }.start();
                    });
                    break;
            }
        }
    }
    static class RunHostProcedure extends Thread {
        private Host hostLocal;

        public RunHostProcedure(Host host) {
            this.hostLocal = host;
        }

        public Host host() {
            return hostLocal;
        }
    }
}
