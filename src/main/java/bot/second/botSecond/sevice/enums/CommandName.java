package bot.second.botSecond.sevice.enums;

public enum CommandName {
    START("/start"),
    MY_DATA("/mydata"),
    HELP("/help"),
    ADD_MASTER("/addmastertodb"),
    DELETE_MASTER("/deletemasterfromdb");

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return  commandName;
    }
}
