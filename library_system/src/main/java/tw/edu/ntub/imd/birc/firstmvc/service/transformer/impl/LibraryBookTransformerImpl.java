package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.LibraryBookBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.LibraryBook;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.LibraryBookTransformer;

@Component
public class LibraryBookTransformerImpl implements LibraryBookTransformer {
    @NonNull
    @Override
    public LibraryBook transferToEntity(@NonNull LibraryBookBean libraryBookBean) {
        return JavaBeanUtils.copy(libraryBookBean, new LibraryBook());
    }

    @NonNull
    @Override
    public LibraryBookBean transferToBean(@NonNull LibraryBook libraryBook) {
        return JavaBeanUtils.copy(libraryBook, new LibraryBookBean());
    }

}
