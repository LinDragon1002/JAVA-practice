package tw.edu.ntub.imd.birc.firstmvc.service.impl;

import tw.edu.ntub.imd.birc.firstmvc.bean.GroupBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao.GroupDAO;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Group;
import tw.edu.ntub.imd.birc.firstmvc.service.GroupService;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.GroupTransformer;

public class GroupServiceImpl extends BaseServiceImpl<GroupBean, Group, String> implements GroupService {
    private final GroupDAO groupDAO;
    private final GroupTransformer transformer;

    public GroupServiceImpl( GroupDAO groupDAO, GroupTransformer transformer) {
        super(groupDAO, transformer);
        this.groupDAO = groupDAO;
        this.transformer = transformer;
    }

    @Override
    public GroupBean save(GroupBean bean) { return null; }
}
