package tw.edu.ntub.imd.birc.firstmvc.service;

import tw.edu.ntub.imd.birc.firstmvc.bean.TeacherBean;

import java.time.LocalDate;
import java.util.List;

public interface TeacherService extends BaseService<TeacherBean, Integer> {
    List<TeacherBean> searchAllByAge(Integer age);
    List<TeacherBean> searchAllByName(String name);
    List<TeacherBean> findAllByAgeIsBetween(Integer startAge, Integer endAge);
    List<TeacherBean> findAllByCreateTimeIsBetween(LocalDate startCreateTime, LocalDate endCreateTime);
}
