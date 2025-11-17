package tw.edu.ntub.imd.birc.practice.service.impl;

import com.google.api.client.auth.openidconnect.IdToken;
import org.apache.commons.math3.analysis.function.Identity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
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
import tw.edu.ntub.imd.birc.practice.exception.BircException;
import tw.edu.ntub.imd.birc.practice.service.UserAccountService;
import tw.edu.ntub.imd.birc.practice.service.transformer.UserAccountTransformer;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import java.util.*;

@Service
public class UserAccountServiceImpl extends BaseServiceImpl<UserAccountBean, UserAccount, Integer> implements UserAccountService {
    private final UserAccountDAO userAccountDAO;
    private final UserAccountTransformer transformer;
    @Value("${google.clientId}")
    private String clientId;

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
        List<String> errorMessages = new ArrayList<>();

        // 檢查電子郵件是否重複
        if (userAccountBean.getEmail() != null && userAccountDAO.existsByEmail(userAccountBean.getEmail())) {
            errorMessages.add("電子郵件已被使用，請使用其他信箱");
        }

        // 如果有任何錯誤，拋出例外
        if (!errorMessages.isEmpty()) {
            String combinedMessage = String.join("；", errorMessages);
            throw new BircException(combinedMessage) {
                @Override
                public String getErrorCode() {
                    return combinedMessage;
                }
            };
        }
        userAccountBean.setPassword(PasswordUtils.encode(userAccountBean.getPassword()));
        userAccountBean.setAvailable(true);
        return save(userAccountBean);
    }
//    傳統登入
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<UserAccount> userAccounts = userAccountDAO.findByAccount(username);
//        String encodepassword = userAccounts.get(0).getPassword();
//
//        return new UserDetails() {
//            @Override
//            public Collection<? extends GrantedAuthority> getAuthorities() {
//                return List.of();
//            }
//
//            @Override
//            public String getPassword() {
//                return encodepassword;
//            }
//
//            @Override
//            public String getUsername() {
//                return userAccounts.toString();
//            }
//
//            @Override
//            public boolean isAccountNonExpired() {
//                return true;
//            }
//
//            @Override
//            public boolean isAccountNonLocked() {
//                return true;
//            }
//
//            @Override
//            public boolean isCredentialsNonExpired() {
//                return true;
//            }
//
//            @Override
//            public boolean isEnabled() {
//                return userAccounts.get(0).getAvailable();
//            }
//        };
//    }

//  google登入
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GoogleIdTokenVerifier verifier =
                new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                        .setAudience(Collections.singletonList(clientId))
                        .build();
        try {
            GoogleIdToken idToken = verifier.verify(username);
            if (idToken != null) {
                IdToken.Payload payload = idToken.getPayload();
                String googleId = payload.getSubject();

                String email = (String) payload.get("email");
                String email_id = email.split("@")[0];
//                email = EmailTransformUtils.remove(email);
                Optional<UserAccount> optional = userAccountDAO.findByEmailId(email_id);

                UserAccount userAccount;
                if (optional.isEmpty()) {
                    userAccount = new UserAccount();
                    userAccount.setEmailId(email_id);
                    userAccount.setUsername((String) payload.get("name"));
                    userAccount.setGoogleId(googleId);
                    userAccount.setAvailable(true);

//                    if (email.length() == 8 && email.matches(
//                            "\\d{8}|[nN]\\d{7}|\\d{4}[a-zA-Z]\\d{3}|[nN]\\d{3}[a-zA-Z]\\d{3}")) {
//                        userAccount.setIdentity(Identity.TA);
//                    } else {
//                        userAccount.setIdentity(Identity.TEACHER);
//                    }
                    userAccountDAO.save(userAccount);
                } else {
                    userAccount = optional.get();
                }

                return new UserDetails() {
                    @Override
                    public Collection<? extends GrantedAuthority> getAuthorities() {
                        List<GrantedAuthority> authorities = new ArrayList<>();
//                        authorities.add(new SimpleGrantedAuthority(userAccount.getIdentity().getTypeName()));
                        return authorities;
                    }

                    @Override
                    public String getPassword() {
                        return googleId;
                    }

                    @Override
                    public String getUsername() {
                        return String.valueOf(userAccount.getSno());
                    }

                    @Override
                    public boolean isAccountNonExpired() {
                        return true;
                    }

                    @Override
                    public boolean isAccountNonLocked() {
                        return true;
                    }

                    @Override
                    public boolean isCredentialsNonExpired() {
                        return true;
                    }

                    @Override
                    public boolean isEnabled() {
                        return userAccount.getAvailable();
                    }
                };
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UsernameNotFoundException("登入失敗");
    }

    @Override
    public UserAccountBean updatePassword(String username,
                                          String currentPassword,
                                          String newPassword) throws Exception {
        List<UserAccount> userAccounts = userAccountDAO.findByAccount(username);
        String encodepassword = userAccounts.get(0).getPassword();
        if (!PasswordUtils.matches(currentPassword, encodepassword)) {
            throw new Exception("密碼錯誤");
        }
        if (newPassword.equals(currentPassword)) {
            throw new Exception("與舊密碼一樣");
        }
        userAccounts.get(0).setPassword(PasswordUtils.encode(newPassword));
        return null;
    }

    @Override
    public List<UserAccountBean> findByAccount(String account) {
        return CollectionUtils.map(userAccountDAO.findByAccount(account), transformer::transferToBean);
    }


}
