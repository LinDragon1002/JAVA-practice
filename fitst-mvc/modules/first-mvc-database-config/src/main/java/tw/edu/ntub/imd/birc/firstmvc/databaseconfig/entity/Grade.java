package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;


import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.listener.MemberListener;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "grade", schema = Config.DATABASE_NAME)
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> grades;

}