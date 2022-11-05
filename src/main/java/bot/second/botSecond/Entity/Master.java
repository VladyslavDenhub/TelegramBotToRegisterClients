package bot.second.botSecond.Entity;

import bot.second.botSecond.sevice.enums.Services;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "masters")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;

    private Services[] service;

    public Master(String name) {
        this.name = name;
        service = Services.values();
    }
    public Master() {
    }

}
