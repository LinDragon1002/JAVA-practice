package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.firstmvc.bean.AuthorBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.AuthorDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Author;
import tw.edu.ntub.imd.birc.firstmvc.service.AuthorService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.AuthorTransformer;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<AuthorBean, Author, Integer> implements AuthorService {
    private final AuthorDAO authorDAO;
    private final AuthorTransformer transformer;

    public AuthorServiceImpl(AuthorDAO authorDAO, AuthorTransformer transformer) {
        super(authorDAO,transformer);
        this.authorDAO = authorDAO;
        this.transformer = transformer;
    }

    @Override
    public AuthorBean save(AuthorBean authorBean){
        authorDAO.save(transformer.transferToEntity(authorBean));
        return null;
    }
}
