package bot.second.botSecond.sevice.enums;

public enum CommandName {
    START("/start"),
    MY_DATA("/mydata");

    private final String commandName;

    CommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return  commandName;
    }
}
