package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.listener;

import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Teacher;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

public class TeacherListener {

    // 新增前檢查
    @PrePersist
    public void PreSave(Teacher teacher) {
        if (teacher.getCreateTime() == null) {
            teacher.setCreateTime(LocalDate.now());
        }
    }

    // 更新前檢查
    @PreUpdate
    public void PreUpdate(Teacher teacher) {
        if (teacher.getCreateTime() == null) {
            teacher.setCreateTime(LocalDate.now());
        }
    }
}
