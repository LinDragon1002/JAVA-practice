package tw.edu.ntub.imd.birc.practice.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.practice.bean.UserAccountBean;
import tw.edu.ntub.imd.birc.practice.config.util.PasswordUtils;
import tw.edu.ntub.imd.birc.practice.databaseconfig.dao.UserAccountDAO;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.UserAccount;
import tw.edu.ntub.imd.birc.practice.service.UserAccountService;
import tw.edu.ntub.imd.birc.practice.service.transformer.UserAccountTransformer;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        userAccountBean.setPassword(PasswordUtils.encode(userAccountBean.getPassword()));
        return save(userAccountBean);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserAccount> userAccounts = userAccountDAO.findByAccount(username);
        if (CollectionUtils.isEmpty(userAccounts)) {
            throw new UsernameNotFoundException(username);
        }
        UserAccount userAccount = userAccounts.get(0);
        return User.builder()
                .username(username)
                .password(PasswordUtils.encode(userAccount.getPassword()))
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
                .build();
    }

    @Override
    public List<UserAccountBean> findByAccount(String account) {
        return CollectionUtils.map(userAccountDAO.findByAccount(account), transformer::transferToBean);
    }


}
