package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.listener.TeacherListener;

import javax.persistence.*;
import java.time.LocalDate;

@Data

@Entity

@EntityListeners(TeacherListener.class)

@Table(name = "teacher" , schema = Config.DATABASE_NAME)

public class Teacher {

    @Id
    // 自動增值(AI)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sno", nullable = false)
    private Integer sno;

    @Column(name = "t_id", length = 6, nullable = false)
    private String t_id;

    @Column(name = "name" , length = 45 , nullable = false)
    private String name;

    @Column(name = "phone" , length = 45 , nullable = false)
    private String phone;

    @Column(name = "create_time", nullable = false)
    private LocalDate createTime;

    @Column(name = "age", nullable = false)
    private Integer age;
}
