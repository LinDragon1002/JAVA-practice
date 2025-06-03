package tw.edu.ntub.imd.birc.firstmvc.service;

import tw.edu.ntub.imd.birc.firstmvc.bean.MemberBean;

import java.util.List;

public interface MemberService extends BaseService<MemberBean, Integer> {
    List<MemberBean> findAllByPage(Integer nowPage,String keyWord);
    int countAll(String keyWord);
}
