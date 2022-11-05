package bot.second.botSecond.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;

}
