package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;


import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.listener.MemberListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "members", schema = Config.DATABASE_NAME)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "gmail", length = 100, nullable = false)
    private String gmail;

    @Column(name = "gender", length = 10, nullable = false)
    private String gender;

    @ManyToOne
    @JoinColumn(name = "grade_id", insertable = false, updatable = false)
    private Grade grade;

    @Column(name = "grade_id", nullable = false)
    private Integer gradeId;

}