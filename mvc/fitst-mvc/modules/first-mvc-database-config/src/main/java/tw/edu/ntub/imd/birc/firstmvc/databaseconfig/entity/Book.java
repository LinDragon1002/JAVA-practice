package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;


import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.listener.BookListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@EntityListeners(BookListener.class)
@Table(name = "book" , schema = Config.DATABASE_NAME)

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sno" , nullable = false)
    private Integer sno;

    @Column(name = "name",length = 45, nullable = false)
    private String name;

    @Column(name = "publication_date", nullable = false)
    private Date publication_date;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;

    @Column(name = "author_id", nullable = false)
    private Integer author_id;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime create_time;

    @Column(name = "info", length = 500, nullable = false)
    private String info;

}
