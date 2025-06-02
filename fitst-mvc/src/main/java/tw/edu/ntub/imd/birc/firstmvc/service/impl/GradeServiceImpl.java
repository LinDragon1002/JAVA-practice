package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.GradeBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.GradeDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Grade;
import tw.edu.ntub.imd.birc.firstmvc.service.GradeService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.GradeTransformer;

import java.util.List;

//告訴spring這是一個service
@Service
//要實作介面，DAO、transformer為建構元傳入參數(DAO不一定只有一個，依需求)
public class GradeServiceImpl extends BaseServiceImpl<GradeBean, Grade, Integer> implements GradeService {
    private final GradeDAO gradeDAO;
    private final GradeTransformer transformer;

    public GradeServiceImpl(GradeDAO gradeDAO, GradeTransformer transformer) {
        super(gradeDAO, transformer);
        this.transformer = transformer;
        this.gradeDAO = gradeDAO;
    }

    @Override
    // 新增，不一定要寫，可以要用到再回來寫
    public GradeBean save(GradeBean gradeBean) {
        return null;
    }

    // 因為原本是全查，但是要增加條件是否啟用，所以才覆寫，不然用父類別的就可以了
//    @Override
//    public List<GradeBean> searchAll() {
//        return CollectionUtils.map(gradeDAO.findByAvailableIsTrue(), transformer::transferToBean);
//    }
}
