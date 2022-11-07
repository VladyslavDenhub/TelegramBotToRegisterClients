package bot.second.botSecond.sevice.enums;

public enum ServicesName {
    MANICURE("Манікюр"),
    PEDICURE("Педікюр"),
    MANICURE_COATING("Манікюр+Покриття"),
    PEDICURE_COATING("Педікюр+Покриття"),
    MANICURE_PEDICURE("Манікюр+Педікюр"),
    EXTENSION("Нарощування"),
    BACK("BACK to START");

    private final String serviceName;

    ServicesName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
