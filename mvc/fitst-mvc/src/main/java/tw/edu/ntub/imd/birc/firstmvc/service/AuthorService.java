package tw.edu.ntub.imd.birc.firstmvc.service;

import org.springframework.data.repository.query.Param;
import tw.edu.ntub.imd.birc.firstmvc.bean.AuthorBean;

import java.util.List;

public interface AuthorService extends BaseService<AuthorBean, Integer> {
    public List<AuthorBean> findAllByName(@Param("id") Integer id);
    public List<AuthorBean> findAllById(Integer id);
}
