package tw.edu.ntub.imd.birc.firstmvc.bean;

import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.LibraryBook;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Member;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Data
public class RecordBean {

    @Null
    private Integer id;

    @NotNull(message = "歸還日期 - 未填寫")
    private String BRDateStr;

    @NotNull(message = "借出日期 - 未填寫")
    private String RTDateStr;

    @Null(message = "最後歸還日期 - 不能填寫")
    private String DLDateStr;

    private LocalDate BRDate;
    private LocalDate RTDate;
    private LocalDate DLDate;
    private Member member;
    private LibraryBook book;

}
