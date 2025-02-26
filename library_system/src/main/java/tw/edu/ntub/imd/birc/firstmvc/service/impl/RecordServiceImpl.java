package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.firstmvc.bean.RecordBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.RecordDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Record;
import tw.edu.ntub.imd.birc.firstmvc.service.RecordService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.RecordTransformer;

@Service
public class RecordServiceImpl extends BaseServiceImpl<RecordBean, Record, String> implements RecordService {
    private final RecordDAO recordDAO;
    private final RecordTransformer transformer;

    public RecordServiceImpl(RecordDAO recordDAO, RecordTransformer transformer) {
        super(recordDAO,transformer);
        this.recordDAO = recordDAO;
        this.transformer = transformer;
    }
    @Override
    public RecordBean save(RecordBean recordBean) { return null; }
}
