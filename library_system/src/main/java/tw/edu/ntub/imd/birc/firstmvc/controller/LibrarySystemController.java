package tw.edu.ntub.imd.birc.firstmvc.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.AuthorBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.LibraryBookBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.RecordBean;
import tw.edu.ntub.imd.birc.firstmvc.service.AuthorService;
import tw.edu.ntub.imd.birc.firstmvc.service.LibraryBookService;
import tw.edu.ntub.imd.birc.firstmvc.service.MemberService;
import tw.edu.ntub.imd.birc.firstmvc.service.RecordService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.array.ArrayData;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/library")
public class LibrarySystemController {
    private final MemberService memberService;
    private final LibraryBookService libraryBookService;
    private final RecordService recordService;
    private final AuthorService authorService;

    @PostMapping(path = "/book")
    public ResponseEntity<String> createbook(@Valid @RequestBody LibraryBookBean libraryBookBean,
                                             BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        libraryBookService.save(libraryBookBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PostMapping(path = "/author")
    public ResponseEntity<String> createauthor(@Valid @RequestBody AuthorBean authorBean,
                                               BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        authorService.save(authorBean);
        return  ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PostMapping(path = "/record")
    public ResponseEntity<String> createrecord(@Valid @RequestBody RecordBean recordBean,
                                               BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        recordBean.setBRDate(LocalDate.parse(formatter.format(recordBean.getBRDate()), formatter));
        recordBean.setRTDate(LocalDate.parse(formatter.format(recordBean.getRTDate()), formatter));
        recordBean.setDLDate(LocalDate.parse(formatter.format(recordBean.getDLDate()), formatter));
        recordService.save(recordBean);
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

    @GetMapping(path = "/author")
    public ResponseEntity<String> getauthor() {
        ArrayData arrayData = new ArrayData();
        for (AuthorBean authorBean : authorService.searchAll()){
            ObjectData objectData = arrayData.addObject();
            objectData.add("id", authorBean.getId());
            objectData.add("name", authorBean.getName());
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @GetMapping(path = "/record")
    public ResponseEntity<String> getrecord() {
        ArrayData arrayData = new ArrayData();
        for (RecordBean recordBean : recordService.searchAll()){
            ObjectData objectData = arrayData.addObject();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            objectData.add("id", recordBean.getId());
            objectData.add("BRDate", formatter.format(recordBean.getBRDate()));
            objectData.add("RTDate", formatter.format(recordBean.getRTDate()));
            objectData.add("DLDate", formatter.format(recordBean.getDLDate()));
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }
}
