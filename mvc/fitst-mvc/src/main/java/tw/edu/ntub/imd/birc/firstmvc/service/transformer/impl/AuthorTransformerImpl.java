package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.AuthorBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.BookBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Author;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Book;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.AuthorTransformer;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.BookTransformer;

@Component
public class AuthorTransformerImpl implements AuthorTransformer {
    @NonNull
    @Override
    public Author transferToEntity(@NonNull AuthorBean authorBean) {
        return JavaBeanUtils.copy(authorBean, new Author());
    }

    @NonNull
    @Override
    public AuthorBean transferToBean(@NonNull Author author) {
        return JavaBeanUtils.copy(author, new AuthorBean());
    }
}
