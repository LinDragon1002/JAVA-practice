package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.RecordBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Record;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.RecordTransformer;

@Component
public class RecordTransformerImpl implements RecordTransformer {
    @NonNull
    @Override
    public Record transferToEntity(@NonNull RecordBean recordBean) {
        return JavaBeanUtils.copy(recordBean, new Record());
    }

    @NonNull
    @Override
    public RecordBean transferToBean(@NonNull Record record) {
        return JavaBeanUtils.copy(record, new RecordBean());
    }
}
