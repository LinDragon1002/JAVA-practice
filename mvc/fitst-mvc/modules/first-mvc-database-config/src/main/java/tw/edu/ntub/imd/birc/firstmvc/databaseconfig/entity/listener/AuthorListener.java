package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.listener;

import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Author;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Book;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AuthorListener {

    // 新增前檢查
    @PrePersist
    public void PreSave(Author author) {
        if (author.getCreate_time() == null) {
            author.setCreate_time(LocalDateTime.now());
        }
//        if (author.getBirthdate() == null) {
//            author.setBirthdate(LocalDate.now());
//        }
    }

    // 更新前檢查
    @PreUpdate
    public void PreUpdate(Author author) {
        if (author.getCreate_time() == null) {
            author.setCreate_time(LocalDateTime.now());
        }
//        if (author.getBirthdate() == null) {
//            author.setBirthdate(LocalDate.now());
//        }
    }
}
