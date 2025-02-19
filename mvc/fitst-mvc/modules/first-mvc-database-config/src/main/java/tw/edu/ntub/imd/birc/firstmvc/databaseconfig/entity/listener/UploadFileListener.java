package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.listener;

import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Author;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.UploadFile;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class UploadFileListener {

    // 新增前檢查
    @PrePersist
    public void PreSave(UploadFile uploadFile) {
        if (uploadFile.getCreate_time() == null) {
            uploadFile.setCreate_time(LocalDateTime.now());
        }
//        if (author.getBirthdate() == null) {
//            author.setBirthdate(LocalDate.now());
//        }
    }

    // 更新前檢查
    @PreUpdate
    public void PreUpdate(UploadFile uploadFile) {
        if (uploadFile.getCreate_time() == null) {
            uploadFile.setCreate_time(LocalDateTime.now());
        }
//        if (author.getBirthdate() == null) {
//            author.setBirthdate(LocalDate.now());
//        }
    }
}
