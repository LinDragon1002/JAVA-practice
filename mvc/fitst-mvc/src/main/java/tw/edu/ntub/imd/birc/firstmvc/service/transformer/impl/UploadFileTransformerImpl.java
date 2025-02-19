package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.AuthorBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.UploadFileBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Author;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.UploadFile;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.AuthorTransformer;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.UploadFileTransformer;

@Component
public class UploadFileTransformerImpl implements UploadFileTransformer {
    @NonNull
    @Override
    public UploadFile transferToEntity(@NonNull UploadFileBean uploadFileBean) {
        return JavaBeanUtils.copy(uploadFileBean, new UploadFile());
    }

    @NonNull
    @Override
    public UploadFileBean transferToBean(@NonNull UploadFile uploadFile) {
        return JavaBeanUtils.copy(uploadFile, new UploadFileBean());
    }
}
