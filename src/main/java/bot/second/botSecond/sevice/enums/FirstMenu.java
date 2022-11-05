package bot.second.botSecond.sevice.enums;

import org.springframework.scheduling.config.FixedRateTask;

public enum FirstMenu {
    RECORD("RECORD"),
    EDIT_RECORD("EDIT RECORD"),
    DELETE_RECORD("DELETE RECORD");

    private String buttonName;

    FirstMenu(String buttonName){
        this.buttonName = buttonName;
    }

    public String getButtonName(){
        return buttonName;
    }
}
