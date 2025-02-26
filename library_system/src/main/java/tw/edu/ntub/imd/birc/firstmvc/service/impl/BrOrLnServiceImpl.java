package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.birc.firstmvc.bean.BrOrLnBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.BrOrLnDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.BrOrLn;
import tw.edu.ntub.imd.birc.firstmvc.service.BrOrLnService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.BrOrLnTransformer;

@Service
public class BrOrLnServiceImpl extends BaseServiceImpl<BrOrLnBean, BrOrLn, String> implements BrOrLnService {
    private final BrOrLnDAO brOrLnDAO;
    private final BrOrLnTransformer transformer;

    public BrOrLnServiceImpl(BrOrLnDAO brOrLnDAO, BrOrLnTransformer transformer) {
        super(brOrLnDAO,transformer);
        this.brOrLnDAO = brOrLnDAO;
        this.transformer = transformer;
    }

    @Override
    public BrOrLnBean save(BrOrLnBean brOrLnBean) { return null; }
}
