package tw.edu.ntub.imd.birc.firstmvc.bean;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
public class BrOrLnBean {

    @Null
    private String id;

    @NotBlank(message = "名字 - 未填寫")
    private String name;
}
