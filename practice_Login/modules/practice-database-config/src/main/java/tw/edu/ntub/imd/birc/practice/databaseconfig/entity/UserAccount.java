package tw.edu.ntub.imd.birc.practice.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.practice.databaseconfig.Config;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.converter.BooleanTo1And0Converter;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.listener.UserAccountListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(UserAccountListener.class)
@Table(name = "useraccount", schema = Config.DATABASE_NAME)
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sno" , nullable = false)
    private Integer sno;

    @Column(name = "email_id", length = 254, nullable = false)
    private String emailId;

    @Column(name = "name",length = 45, nullable = false)
    private String username;

    @Column(name = "email", length = 254, nullable = false)
    private String email;

    @Column(name = "account", length = 254, nullable = false)
    private String account;

    @Column(name = "password", length = 254, nullable = false)
    private String password;

    @Convert(converter = BooleanTo1And0Converter.class)
    @Column(name = "available" , nullable = false)
    private Boolean available;

    @Column(name = "createdate", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "modifydate", nullable = false)
    private LocalDateTime modifyDate;

    @Column(name = "google_id", length = 254, nullable = false)
    private String googleId;


}
