package tw.edu.ntub.imd.birc.practice.service;

import tw.edu.ntub.imd.birc.practice.bean.UserAccountBean;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.UserAccount;

public interface UserAccountService extends BaseService<UserAccountBean, Integer> {
    UserAccountBean registerUserAccount(UserAccountBean userAccountBean);
}
