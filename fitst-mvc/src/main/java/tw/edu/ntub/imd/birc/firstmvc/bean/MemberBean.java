package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Grade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
// 前端資料需要的格式，基本上會跟entity一樣，但是可以因為需求而增加變數
public class MemberBean {
    @Null
    private Integer id;

    @NotBlank(message = "姓名 - 未填寫")
    private String name;

    @NotBlank(message = "郵件 - 未填寫")
    private String gmail;

    @NotNull(message = "性別編號 - 未填寫")
    private String gender;

    @NotNull(message = "年級編號 - 未填寫")
    private Integer gradeId;

    private Grade grade;

}
