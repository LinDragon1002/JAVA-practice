package tw.edu.ntub.imd.birc.firstmvc.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AuthorBean {
    @Null
    private Integer id;

    @NotBlank(message = "姓名 - 未填寫")
    private String name;

    @NotNull(message = "日期 - 未填寫")
    private String birthdateStr;

    @Null(message = "日期 - 不能填寫")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_time;

    @NotBlank(message = "資訊 - 未填寫")
    private String info;

    private LocalDate birthdate;
}

