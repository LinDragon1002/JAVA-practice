package tw.edu.ntub.imd.birc.practice.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.practice.databaseconfig.Config;

import javax.persistence.*;

@Data
@Entity
@Table(name = "useraccount", schema = Config.DATABASE_NAME)
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sno" , nullable = false)
    private Integer sno;

    @Column(name = "name",length = 45, nullable = false)
    private String name;

    @Column(name = "email", length = 254, nullable = false)
    private String email;

    @Column(name = "account", length = 254, nullable = false)
    private String account;

    @Column(name = "password", length = 254, nullable = false)
    private String password;
}
