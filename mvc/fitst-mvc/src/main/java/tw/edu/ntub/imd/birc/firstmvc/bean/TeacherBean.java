package tw.edu.ntub.imd.birc.firstmvc.bean;

import  lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class TeacherBean {
    @NotBlank(message = "教職員編號 - 未填寫")
    @Size(min = 6, max = 6, message = "輸入字數要等於{min}個字")
    private String t_id;
    @NotBlank(message = "姓名 - 未填寫")
    private String name;
    @NotBlank(message = "電話 - 未填寫")
    private String phone;
    private LocalDate createTime;
    @NotBlank(message = "入值日期 - 未填寫")
    private String createTimeStr;
    @NotNull(message = "年齡 - 未填寫")
    @Max(110)
    @Min(0)
    private Integer age;
}
