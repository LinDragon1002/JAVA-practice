package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;


import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.listener.AuthorListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EntityListeners(AuthorListener.class)
@Table(name = "author", schema = Config.DATABASE_NAME)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name",length = 45, nullable = false)
    private String name;

    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime create_time;

    @Column(name = "info", length = 500, nullable = false)
    private String info;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;


}
