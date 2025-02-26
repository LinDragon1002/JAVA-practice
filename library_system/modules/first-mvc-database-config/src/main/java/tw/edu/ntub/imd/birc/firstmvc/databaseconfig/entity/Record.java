package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity;


import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.Config;

import javax.persistence.*;
import java.awt.print.Book;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "record", schema = Config.DATABASE_NAME)
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "BRDate",nullable = false)
    private LocalDate BRDate;

    @Column(name = "RTDate",nullable = false)
    private LocalDate RTDate;

    @Column(name = "DLDate",nullable = false)
    private LocalDate DLDate;

    @ManyToOne
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private LibraryBook book;
}
