package bot.second.botSecond.sevice.enums;

import bot.second.botSecond.Entity.Master;

public enum MastersName {
    ANNA("ANNA"),
    VITALII("Vitalii"),
    BORIS("Boris");

    private String name;
    MastersName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
