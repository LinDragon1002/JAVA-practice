package tw.edu.ntub.imd.birc.practice.databaseconfig.entity.listener;

import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.UserAccount;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class UserAccountListener {
    @PrePersist
    public void preSave(UserAccount userAccount) {
        LocalDateTime now = LocalDateTime.now();
        if (userAccount.getAvailable() == null) {
            userAccount.setAvailable(false);
        }
        if (userAccount.getCreateDate() == null) {
            userAccount.setCreateDate(now);
        }
        if (userAccount.getModifyDate() == null) {
            userAccount.setModifyDate(now);
        }
    }

    @PreUpdate
    public void preUpdate(UserAccount userAccount) {
        userAccount.setModifyDate(LocalDateTime.now());
    }
}
