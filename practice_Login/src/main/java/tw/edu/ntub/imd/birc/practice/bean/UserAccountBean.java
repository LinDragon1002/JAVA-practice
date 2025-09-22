package tw.edu.ntub.imd.birc.practice.bean;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class UserAccountBean {
    @Null
    private Integer sno;

    @Size(max = 50, message = "姓名 - 不可超過{max}個字")
    @NotEmpty(message = "姓名 - 未填寫")
    private String username;

    @Size(max = 254, message = "email - 不可超過{max}個字")
    @NotEmpty(message = "email - 未填寫")
    private String email;

    @Size(max = 254, message = "account - 不可超過{max}個字")
    @NotEmpty(message = "account - 未填寫")
    private String account;

    @Size(max = 254, message = "password - 不可超過{max}個字")
    @NotEmpty(message = "password - 未填寫")
    private String password;

    private Boolean available;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
