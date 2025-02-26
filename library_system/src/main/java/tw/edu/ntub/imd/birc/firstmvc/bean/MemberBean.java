package tw.edu.ntub.imd.birc.firstmvc.bean;


import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Group;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
public class MemberBean {
    @Null
    private Integer id;

    @NotBlank(message = "名字 - 未填寫")
    private String name;

    @NotBlank(message = "帳號 - 未填寫")
    private String account;

    @NotBlank(message = "密碼 - 未填寫")
    private String password;

    private Group group;


}
