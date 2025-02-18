package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Teacher;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TeacherDAO extends BaseDAO<Teacher, Integer> {
    List<Teacher> findAllByAge(Integer age);
    List<Teacher> findAllByName(String name);
    List<Teacher> findAllByAgeIsBetween(Integer startAge, Integer endAge);
    List<Teacher> findAllByCreateTimeIsBetween(LocalDate startCreateTime, LocalDate endCreateTime);

//    CRUD creat read update delete
}
