package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.firstmvc.bean.LibraryBookBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.LibraryBookDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.LibraryBook;
import tw.edu.ntub.imd.birc.firstmvc.service.LibraryBookService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.LibraryBookTransformer;

@Service
public class LibraryBookServiceImpl extends BaseServiceImpl<LibraryBookBean, LibraryBook, Integer> implements LibraryBookService {
    private final LibraryBookDAO libraryBookDAO;
    private final LibraryBookTransformer transformer;

    public LibraryBookServiceImpl(LibraryBookDAO libraryBookDAO, LibraryBookTransformer transformer) {
        super(libraryBookDAO,transformer);
        this.libraryBookDAO = libraryBookDAO;
        this.transformer = transformer;
    }

    @Override
    public LibraryBookBean save(LibraryBookBean libraryBookBean) {
        libraryBookDAO.save(transformer.transferToEntity(libraryBookBean));
        return null;
    }
}
