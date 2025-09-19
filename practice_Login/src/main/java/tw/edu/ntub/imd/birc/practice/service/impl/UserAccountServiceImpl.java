package tw.edu.ntub.imd.birc.practice.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.practice.bean.UserAccountBean;
import tw.edu.ntub.imd.birc.practice.config.util.PasswordUtils;
import tw.edu.ntub.imd.birc.practice.databaseconfig.dao.UserAccountDAO;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.UserAccount;
import tw.edu.ntub.imd.birc.practice.service.UserAccountService;
import tw.edu.ntub.imd.birc.practice.service.transformer.UserAccountTransformer;

@Service
public class UserAccountServiceImpl extends BaseServiceImpl<UserAccountBean, UserAccount, Integer> implements UserAccountService {
    private final UserAccountDAO userAccountDAO;
    private final UserAccountTransformer transformer;

    public UserAccountServiceImpl(UserAccountDAO userAccountDAO, UserAccountTransformer transformer) {
        super(userAccountDAO, transformer);
        this.userAccountDAO = userAccountDAO;
        this.transformer = transformer;
    }


    @Override
    public UserAccountBean save(UserAccountBean userAccountBean) {
        userAccountDAO.save(transformer.transferToEntity(userAccountBean));
        return null;
    }

    @Override
    public UserAccountBean registerUserAccount(UserAccountBean userAccountBean) {
        UserAccount userAccount = transformer.transferToEntity(userAccountBean);
        userAccount.setPassword(PasswordUtils.encode(userAccountBean.getPassword()));
        return save(userAccountBean);
    }


}
