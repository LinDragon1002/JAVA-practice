package tw.edu.ntub.imd.birc.firstmvc.controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.LibraryBookBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.LibraryBook;
import tw.edu.ntub.imd.birc.firstmvc.service.LibraryBookService;
import tw.edu.ntub.imd.birc.firstmvc.service.MemberService;
import tw.edu.ntub.imd.birc.firstmvc.service.RecordService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.array.ArrayData;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/library")
public class LibrarySystem {
    private final MemberService memberService;
    private final LibraryBookService libraryBookService;
    private final RecordService recordService;

    @PostMapping(path = "/book")
    public ResponseEntity<String> createbook(@Valid @RequestBody LibraryBookBean libraryBookBean,
                                             BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);

        libraryBookService.save(libraryBookBean);

        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @GetMapping(path = "/book")
    public ResponseEntity<String> getbook() {
        ArrayData arrayData = new ArrayData();
        for (LibraryBookBean libraryBookBean : libraryBookService.searchAll()){
            ObjectData objectData = arrayData.addObject();
            objectData.add("id", libraryBookBean.getId());
            objectData.add("name", libraryBookBean.getName());
            objectData.add("author_id", libraryBookBean.getAuthor().getId());
            objectData.add("brorin_id", libraryBookBean.getBrOrLn().getId());
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }
}
