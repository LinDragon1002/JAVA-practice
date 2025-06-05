package tw.edu.ntub.imd.birc.firstmvc.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Author;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BookBean {
    @Null
    private Integer sno;

    @NotBlank(message = "姓名 - 未填寫")
    private String name;

    @NotNull(message = "日期 - 未填寫")
    private String publicationDateStr;

    @Null(message = "日期 - 不能填寫")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime create_time;

    @NotNull(message = "作者編號 - 未填寫")
    private Integer author_id;

    @NotBlank(message = "資訊 - 未填寫")
    private String info;

    private Author author;

    private LocalDate publicationDate;

    private MultipartFile[] files;
}

