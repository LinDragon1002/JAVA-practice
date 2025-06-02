package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.CollectionUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.MemberBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.MemberDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.specification.MemberSpecification;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Member;
import tw.edu.ntub.imd.birc.firstmvc.service.MemberService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.MemberTransformer;

import java.util.ArrayList;
import java.util.List;

//告訴spring這是一個service
@Service
//要實作介面，DAO、transformer為建構元傳入參數(DAO不一定只有一個，依需求)
public class MemberServiceImpl extends BaseServiceImpl<MemberBean, Member, Integer> implements MemberService {
    private final MemberDAO memberDAO;
    private final MemberTransformer transformer;
    private final MemberSpecification memberSpecification;

    public MemberServiceImpl(MemberDAO memberDAO, MemberTransformer transformer, MemberSpecification memberSpecification) {
        super(memberDAO, transformer);
        this.memberDAO = memberDAO;
        this.transformer = transformer;
        this.memberSpecification = memberSpecification;
    }

    @Override
    // 新增，不一定要寫，可以要用到再回來寫
    public MemberBean save(MemberBean memberBean) {
        Member member = memberDAO.save(transformer.transferToEntity(memberBean));
        return transformer.transferToBean(member);
    }

    // 因為原本是全查，但是要增加條件是否啟用，所以才覆寫，不然用父類別的就可以了
    @Override
    public List<MemberBean> searchAll(String keyWord) {
        List<MemberBean> memberBeanList =  new ArrayList<>();
        for (Member member : memberDAO.findAll(memberSpecification.checkBlank(keyWord))) {
            MemberBean memberBean = new MemberBean();
            memberBean.setId(member.getId());
            memberBean.setName(member.getName());
            memberBean.setGmail(member.getGmail());
            memberBean.setGender(member.getGender());
            memberBean.setGradeId(member.getGradeId());
            memberBean.setGrade(member.getGrade());
            memberBeanList.add(memberBean);
        }
        return memberBeanList;
    }
}
