package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.listener;

import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Book;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Teacher;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookListener {

    // 新增前檢查
    @PrePersist
    public void PreSave(Book book) {
        if (book.getCreate_time() == null) {
            book.setCreate_time(LocalDateTime.now());
        }
//        if (book.getAuthor_id() == null) {
//            book.getAuthor().getId();
//        }
    }

    // 更新前檢查
    @PreUpdate
    public void PreUpdate(Book book) {
        if (book.getCreate_time() == null) {
            book.setCreate_time(LocalDateTime.now());
        }
//        if (book.getPublication_date() == null) {
//            book.setPublication_date(LocalDate.now());
//        }
//        if (book.getAuthor_id() == null) {
//            book.getAuthor().getId();
//        }
    }
}
