package bot.second.botSecond.sevice.enums;

public enum MastersName {
    ANNA("Аннуш"),
    VITALII("Віталій"),
    BORIS("Сергій"),
    BACK("назад до початку");

    private final String name;
    MastersName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
