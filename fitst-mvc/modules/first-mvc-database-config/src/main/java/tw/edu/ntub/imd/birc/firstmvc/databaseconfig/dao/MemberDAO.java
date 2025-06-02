package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Member;

import java.util.List;


// 告訴spring這是一個Repository(DAO)
@Repository
//DAO的介面，要繼承BaseDAO<entity, pk型態>
public interface MemberDAO extends BaseDAO<Member, Integer>, JpaSpecificationExecutor<Member> {
//    public List<Member> searchAllBy(String keyWord);
}
