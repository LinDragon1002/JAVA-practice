package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.StringUtils;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Member;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Member_;

import java.util.ArrayList;
import java.util.List;
import javax. persistence. criteria. Predicate;

@Component
public class MemberSpecification {
    public Specification<Member> checkBlank(
            String keyword
    ){
      return (root, query, criteriaBuilder) -> {
          List<Predicate> predicates = new ArrayList<>();
          if (keyword != null && !keyword.isEmpty()) {
              predicates.add(
                      criteriaBuilder.or(
                              criteriaBuilder.like(root.get(Member_.name), "%" + keyword + "%"),
                              criteriaBuilder.like(root.get(Member_.gmail), "%" + keyword + "%")
                      )
              );
          }

          return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
      };
    }

}
