package tw.edu.ntub.imd.birc.firstmvc.service;

import tw.edu.ntub.imd.birc.firstmvc.bean.BookBean;

import java.time.LocalDate;
import java.util.List;

public interface BookService extends BaseService<BookBean, Integer> {
    public List<BookBean> findAllBySno(Integer id);

}
