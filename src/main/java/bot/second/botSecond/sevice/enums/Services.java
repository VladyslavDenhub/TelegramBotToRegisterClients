package bot.second.botSecond.sevice.enums;

public enum Services {
    MANICURE("MANICURE"),
    PEDICURE("PEDICURE"),
    EXTENSION("EXTENSION");

    private String serviceName;

    Services(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
