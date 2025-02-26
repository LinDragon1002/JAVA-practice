package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.BrOrLnBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.BrOrLn;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.BrOrLnTransformer;

@Component
public class BrOrLnTransformerImpl implements BrOrLnTransformer {
    @NonNull
    @Override
    public BrOrLn transferToEntity(@NonNull BrOrLnBean brOrLnBean) {
        return JavaBeanUtils.copy(brOrLnBean, new BrOrLn());
    }

    @NonNull
    @Override
    public BrOrLnBean transferToBean(@NonNull BrOrLn brOrLn) {
        return JavaBeanUtils.copy(brOrLn, new BrOrLnBean());
    }
}
