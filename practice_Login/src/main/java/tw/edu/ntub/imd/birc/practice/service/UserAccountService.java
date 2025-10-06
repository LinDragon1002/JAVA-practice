package tw.edu.ntub.imd.birc.practice.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tw.edu.ntub.imd.birc.practice.bean.UserAccountBean;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.UserAccount;

import java.security.Principal;
import java.util.List;

public interface UserAccountService extends BaseService<UserAccountBean, Integer>, UserDetailsService {
    UserAccountBean registerUserAccount(UserAccountBean userAccountBean);
    List<UserAccountBean> findByAccount(String account);
    UserAccountBean updatePassword(String username, String currentPassword, String newPassword) throws Exception;
}
