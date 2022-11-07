package bot.second.botSecond.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "masters")
public class Master implements MyEntity {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "masterTelegramName")
    private String masterTelegramName;
    @Column(name = "masterFirstName")
    private String masterFirstName;
    @Column(name = "masterLastName")
    private String masterLastName;
    @Column(name = "phone_number")
    private String phoneNumber;



}
