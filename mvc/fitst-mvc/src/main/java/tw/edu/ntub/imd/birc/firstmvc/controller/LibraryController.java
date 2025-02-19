package tw.edu.ntub.imd.birc.firstmvc.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tw.edu.ntub.imd.birc.firstmvc.bean.AuthorBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.BookBean;
//import tw.edu.ntub.imd.birc.firstmvc.bean.UploadFileBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.UploadFileBean;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Book;
import tw.edu.ntub.imd.birc.firstmvc.dto.file.uploader.MultipartFileUploader;
import tw.edu.ntub.imd.birc.firstmvc.dto.file.uploader.Uploader;
import tw.edu.ntub.imd.birc.firstmvc.service.AuthorService;
import tw.edu.ntub.imd.birc.firstmvc.service.BookService;
//import tw.edu.ntub.imd.birc.firstmvc.service.UploadFileService;
import tw.edu.ntub.imd.birc.firstmvc.service.UploadFileService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.array.ArrayData;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@AllArgsConstructor
@RestController
@RequestMapping("")
public class LibraryController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final UploadFileService uploadFileService;

    @PostMapping(path = "/book")
    public ResponseEntity<String> createLibrary(@Valid BookBean bookBean,
                                                BindingResult bindingResult,
                                                MultipartFile[] files) {
        for(MultipartFile file : files) {
            UploadFileBean uploadFileBean = new UploadFileBean();
            uploadFileBean.setTable_id(1);
            uploadFileBean.setTable_name(bookBean.getName());
            uploadFileBean.setFile(file);
            uploadFileService.save(uploadFileBean);
        }

        BindingResultUtils.validate(bindingResult);
        String dateStr = bookBean.getPublicationDateStr(); // 取得日期字串
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 設定格式
        bookBean.setPublicationDate(LocalDate.parse(dateStr, formatter)); // 設定 LocalDate

        bookService.save(bookBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PostMapping(path = "/author")
    public ResponseEntity<String> createLibrary(@Valid @RequestBody AuthorBean authorBean,
                                                BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        authorBean.setBirthdate(LocalDate.parse(authorBean.getBirthdateStr(), formatter));
        authorService.save(authorBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @GetMapping(path = "/book")
    public ResponseEntity<String> getLibraryBooks() {
        ArrayData arrayData = new ArrayData();
        for (BookBean bookBean : bookService.searchAll()) {
            ObjectData objectData = arrayData.addObject();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            objectData.add("id", bookBean.getSno());
            objectData.add("name" , bookBean.getName());
            objectData.add("info", bookBean.getInfo());
            objectData.add("publicationDate", formatter.format(bookBean.getPublicationDate()));
            objectData.add("authorName", bookBean.getAuthor().getName());
            objectData.add("authorId", bookBean.getAuthor().getId());
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @GetMapping(path = "/author")
    public ResponseEntity<String> getLibraryAuthors() {
        ArrayData arrayData = new ArrayData();
        for (AuthorBean authorBean : authorService.searchAll()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            ObjectData objectData = arrayData.addObject();
            objectData.add("id", authorBean.getId());
            objectData.add("name" , authorBean.getName());
            objectData.add("info", authorBean.getInfo());
            objectData.add("birthDate", formatter.format(authorBean.getBirthdate()));
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @GetMapping(path = "/author", params = {"id"})
    public ResponseEntity<String> getLibraryAuthorId(@RequestParam (name = "id") Integer id) {
        ArrayData arrayData = new ArrayData();

        for (AuthorBean authorBean : authorService.findAllById(id)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            ObjectData objectData = arrayData.addObject();
            objectData.add("id", id);
            objectData.add("name" , authorBean.getName());
            objectData.add("info", authorBean.getInfo());
            objectData.add("birthDate", formatter.format(authorBean.getBirthdate()));
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @GetMapping(path = "/book", params = {"id"})
    public ResponseEntity<String> getLibraryBooks(@RequestParam(name = "id") Integer id) {
        ArrayData arrayData = new ArrayData();
        for (BookBean bookBean : bookService.findAllBySno(id)) {
            ObjectData objectData = arrayData.addObject();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            objectData.add("id", id);
            objectData.add("name" , bookBean.getName());
            objectData.add("info", bookBean.getInfo());
            objectData.add("publicationDate", formatter.format(bookBean.getPublicationDate()));
            objectData.add("authorName", bookBean.getAuthor().getName());
            objectData.add("authorId", bookBean.getAuthor_id());
        }
        return ResponseEntityBuilder.error()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @PatchMapping(path = "/book/{sno}")
    public ResponseEntity<String> updateTeacher(@PathVariable Integer sno,
                                                @RequestBody BookBean bookBean){
        bookService.update(sno, bookBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @PatchMapping(path = "/author/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable Integer id,
                                               @RequestBody AuthorBean authorBean){
        authorService.update(id, authorBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @DeleteMapping(path = "/book/{id}")
    public ResponseEntity<String> deleteLibraryBooks(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }

    @DeleteMapping(path = "/author/{id}")
    public ResponseEntity<String> deleteLibraryAuthors(@PathVariable Integer id) {
        authorService.delete(id);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }
}
