package tw.edu.ntub.imd.birc.firstmvc.bean;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UploadFileBean {
    @Null
    private Integer id;

    @NotBlank(message = "姓名 - 未填寫")
    private String path;

    @Null
    private Integer tableid;

    @Null
    private String table_name;

    @Null(message = "日期 - 不能填寫")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_time;

    private MultipartFile file;
}

