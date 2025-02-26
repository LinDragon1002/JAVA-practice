package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.listener;

import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Member;

import javax.persistence.PrePersist;

public class MemberListener {

    @PrePersist
    public void PreSave(Member member){
    }
}
