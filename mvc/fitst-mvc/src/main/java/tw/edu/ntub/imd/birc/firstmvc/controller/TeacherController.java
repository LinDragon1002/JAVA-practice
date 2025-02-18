package tw.edu.ntub.imd.birc.firstmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.TeacherBean;
import tw.edu.ntub.imd.birc.firstmvc.service.TeacherService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.array.ArrayData;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.time.LocalDate;


@AllArgsConstructor
@RestController
@RequestMapping(path = "/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    @PostMapping(path = "/create")
    public ResponseEntity<String> createTeacher(@Valid @RequestBody TeacherBean teacherBean,
                                                BindingResult bindingResult){
        BindingResultUtils.validate(bindingResult);
        teacherBean.setCreateTime(LocalDate.parse(teacherBean.getCreateTimeStr()));
        teacherService.save(teacherBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @DeleteMapping(path = "/delete/{sno}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Integer sno){
        teacherService.delete(sno);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();

    }

    @PatchMapping(path = "/update/{sno}")
    public ResponseEntity<String> updateTeacher(@PathVariable Integer sno, @RequestBody TeacherBean teacherBean){
        teacherBean.setCreateTime(LocalDate.parse(teacherBean.getCreateTimeStr()));
        teacherService.update(sno, teacherBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @GetMapping(path = "", params = {"age"})
    public ResponseEntity<String> getTeacher(@RequestParam (name = "age") Integer age){
        ArrayData arrayData = new ArrayData();
        for (TeacherBean teacherBean : teacherService.searchAllByAge(age)) {
            ObjectData objectData = arrayData.addObject();
            objectData.add("sno", teacherBean.getT_id());
            objectData.add("t_id", teacherBean.getT_id());
            objectData.add("name", teacherBean.getName());
            objectData.add("age", teacherBean.getAge());
        }

        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @GetMapping(path = "", params = {"name"})
    public ResponseEntity<String> getTeacherName(@RequestParam (name = "name") String name){
        ArrayData arrayData = new ArrayData();
        for (TeacherBean teacherBean : teacherService.searchAllByName(name)) {
            ObjectData objectData = arrayData.addObject();
            objectData.add("sno", teacherBean.getT_id());
            objectData.add("t_id", teacherBean.getT_id());
            objectData.add("name", teacherBean.getName());
            objectData.add("age", teacherBean.getAge());
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @GetMapping(path = "", params = {"startAge","endAge"})
    public ResponseEntity<String> getTeacherAge(@RequestParam (name = "startAge") Integer startAge,
                                                @RequestParam (name = "endAge") Integer endAge){
        ArrayData arrayData = new ArrayData();
        for (TeacherBean teacherBean : teacherService.findAllByAgeIsBetween(startAge,endAge)) {
            ObjectData objectData = arrayData.addObject();
            objectData.add("sno", teacherBean.getT_id());
            objectData.add("t_id", teacherBean.getT_id());
            objectData.add("name", teacherBean.getName());
            objectData.add("age", teacherBean.getAge());
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @GetMapping(path = "", params = {"startCreateTime","endCreateTime"})
    public ResponseEntity<String> getTeacherCreatTime(@RequestParam (name = "startCreateTime") String startCreateTime,
                                                      @RequestParam (name = "endCreateTime") String endCreateTime){
        ArrayData arrayData = new ArrayData();
        for (TeacherBean teacherBean : teacherService.findAllByCreateTimeIsBetween(LocalDate.parse(startCreateTime),LocalDate.parse(endCreateTime))) {
            ObjectData objectData = arrayData.addObject();
            objectData.add("sno", teacherBean.getT_id());
            objectData.add("t_id", teacherBean.getT_id());
            objectData.add("name", teacherBean.getName());
            objectData.add("age", teacherBean.getAge());
            objectData.add("create_time", teacherBean.getCreateTime());
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }
}
