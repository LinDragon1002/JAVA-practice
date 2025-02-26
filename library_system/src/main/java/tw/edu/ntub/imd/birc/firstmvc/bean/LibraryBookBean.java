package tw.edu.ntub.imd.birc.firstmvc.bean;


import lombok.Data;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Author;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.BrOrLn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
public class LibraryBookBean {
    @Null
    private String id;

    @NotBlank(message = "名字 - 未填寫")
    private String name;

    private BrOrLn brOrLn;
    private Author author;
}
