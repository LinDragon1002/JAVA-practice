package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.firstmvc.bean.MemberBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Member;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.MemberDAO;
import tw.edu.ntub.imd.birc.firstmvc.service.MemberService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.MemberTransformer;


@Service
public class MemberServiceImpl extends BaseServiceImpl<MemberBean, Member, String> implements MemberService {
    private final MemberDAO memberDAO;
    private final MemberTransformer transformer;

    public MemberServiceImpl(MemberDAO memberDAO, MemberTransformer transformer) {
        super(memberDAO, transformer);
        this.memberDAO = memberDAO;
        this.transformer = transformer;
    }
    @Override
    // 新增，不一定要寫，可以要用到再回來寫
    public MemberBean save(MemberBean memberBean) {
        return null;
    }


}
