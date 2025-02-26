package tw.edu.ntub.imd.birc.firstmvc.service.transformer.impl;

import org.springframework.lang.NonNull;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.birc.firstmvc.bean.GroupBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Group;
import tw.edu.ntub.imd.birc.firstmvc.service.transformer.GroupTransformer;

public class GroupTransformerImpl implements GroupTransformer {
    @NonNull
    @Override
    public Group transferToEntity(@NonNull GroupBean groupBean) {
        return JavaBeanUtils.copy(groupBean, new Group());
    }

    @NonNull
    @Override
    public GroupBean transferToBean(@NonNull Group group) {
        return JavaBeanUtils.copy(group, new GroupBean());
    }
}
