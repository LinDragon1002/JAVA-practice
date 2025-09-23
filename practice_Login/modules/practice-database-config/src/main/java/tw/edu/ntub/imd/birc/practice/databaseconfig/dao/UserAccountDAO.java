package tw.edu.ntub.imd.birc.practice.databaseconfig.dao;

import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.practice.databaseconfig.entity.UserAccount;

import java.util.List;

@Repository
public interface UserAccountDAO extends BaseDAO<UserAccount, Integer>{
    List<UserAccount> findByAccount(String account);
    Boolean existsByEmail(String email);
}
