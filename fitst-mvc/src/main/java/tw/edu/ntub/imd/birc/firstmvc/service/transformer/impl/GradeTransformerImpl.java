package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;


import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.GradeBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.MemberBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Grade;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Member;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.GradeTransformer;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.MemberTransformer;

@Component
public class GradeTransformerImpl implements GradeTransformer {
    // 記得import spring的
    @NonNull
    @Override
    public Grade transferToEntity(@NonNull GradeBean gradeBean) {
        // 複製左邊的給右邊的，null不複製、名字要相同
        return JavaBeanUtils.copy(gradeBean, new Grade());
    }

    @NonNull
    @Override
    public GradeBean transferToBean(@NonNull Grade grade) {
        return JavaBeanUtils.copy(grade, new GradeBean());
    }
}
