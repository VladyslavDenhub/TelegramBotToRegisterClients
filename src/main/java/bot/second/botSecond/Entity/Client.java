package bot.second.botSecond.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "client")
public class Client implements MyEntity {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String userName;

    @Column(name = "userFirstName")
    private String userFirstName;

    @Column(name = "userLastName")
    private String userLastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
