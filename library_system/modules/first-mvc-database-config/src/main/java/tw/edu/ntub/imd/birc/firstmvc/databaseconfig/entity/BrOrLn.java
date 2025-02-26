package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;


import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "brorln", schema = Config.DATABASE_NAME)
public class BrOrLn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "brOrLn", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<LibraryBook> brOrLns;
}
