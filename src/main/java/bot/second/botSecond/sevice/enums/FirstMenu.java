package bot.second.botSecond.sevice.enums;

public enum FirstMenu {
    APPOINTMENT("Створити запис"),
    EDIT_APPOINTMENT("Редагувати запис"),
    DELETE_APPOINTMENT("Видалити запис");

    private final String buttonName;

    FirstMenu(String buttonName){
        this.buttonName = buttonName;
    }

    public String getButtonName(){
        return buttonName;
    }
}
