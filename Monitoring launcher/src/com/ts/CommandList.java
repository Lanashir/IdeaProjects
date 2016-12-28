package com.ts;

/**
 * Created by agosipov on 21.09.2016.
 */
public enum CommandList{
    START   ("-start" ),
    STATUS  ("-status"),
    DELETE  ("-delete"),
    STOP    ("-stop"  ),
    DEPLOY  ("-deploy"),
    HELP    ("-help"  ),
    LOGS    ("-logs"  ),
    FIND    ("-find"  ),
    CHECK   ("-check" );

    private final String Command;
    CommandList(String Command){
        this.Command = Command;
    }

    public String GetCommand(){
        return this.Command;
    }

    public static CommandList getByCommand(String Command) {
        for(CommandList e : values()) {
            if(e.Command.equals(Command)) return e;
        }
        return null;
    }

}