package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.BookBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Book;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.BookTransformer;

@Component
public class BookTransformerImpl implements BookTransformer {
    @NonNull
    @Override
    public Book transferToEntity(@NonNull BookBean bookBean) {
        return JavaBeanUtils.copy(bookBean, new Book());
    }

    @NonNull
    @Override
    public BookBean transferToBean(@NonNull Book book) {
        return JavaBeanUtils.copy(book, new BookBean());
    }
}
