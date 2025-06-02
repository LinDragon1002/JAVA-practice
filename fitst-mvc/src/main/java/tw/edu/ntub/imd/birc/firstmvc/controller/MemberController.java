package tw.edu.ntub.imd.birc.firstmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.firstmvc.bean.GradeBean;
import tw.edu.ntub.imd.birc.firstmvc.bean.MemberBean;
import tw.edu.ntub.imd.birc.firstmvc.service.MemberService;
import tw.edu.ntub.imd.birc.firstmvc.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.firstmvc.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.firstmvc.util.json.array.ArrayData;
import tw.edu.ntub.imd.birc.firstmvc.util.json.object.ObjectData;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping(path = "")
    public ResponseEntity<String> searchMember() {
        ArrayData arrayData = new ArrayData();
        for (MemberBean memberBean : memberService.searchAll()) {
            ObjectData objectData = arrayData.addObject();
            objectData.add("id", memberBean.getId());
            objectData.add("name", memberBean.getName());
            objectData.add("gmail", memberBean.getGmail());
            objectData.add("gender", memberBean.getGender().equals("0") ? "男" : "女");
            objectData.add("gradeId", memberBean.getGradeId());
            objectData.add("gradeName", memberBean.getGrade().getName());
        }
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    @GetMapping(path = "", params = {"id"})
    public ResponseEntity<String> getMember(@RequestParam(name = "id") Integer id) {
        ObjectData objectData = new ObjectData();
        Optional<MemberBean> memberBeanOptional = memberService.getById(id);
        memberBeanOptional.orElseThrow(() -> new RuntimeException("查無此學生，請確認學號是否正確"));
        MemberBean memberBean = memberBeanOptional.get();
        objectData.add("id", memberBean.getId());
        objectData.add("name", memberBean.getName());
        objectData.add("gender", memberBean.getGender().equals("0") ? "男" : "女");
        objectData.add("gradeId", memberBean.getGradeId());
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(objectData)
                .build();
    }
    @GetMapping(path = "/list", params = {"keyWord"})
    public ResponseEntity<String> searchAllBySpec(@RequestParam(value = "keyWord", required = false) String keyWord){
        ArrayData arrayData = new ArrayData();
        for (MemberBean memberBean : memberService.searchAll(keyWord)) {
            ObjectData objectData = arrayData.addObject();
            objectData.add("id", memberBean.getId());
            objectData.add("name", memberBean.getName());
            objectData.add("gender", memberBean.getGender().equals("0") ? "男" : "女");
            objectData.add("gradeId", memberBean.getGradeId());
            objectData.add("gradeName", memberBean.getGrade().getName());
        }
        return ResponseEntityBuilder.success()
                .data(arrayData)
                .build();
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> addMember(@Valid @RequestBody MemberBean memberBean,
                                             BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        memberService.save(memberBean);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }

    @PatchMapping(path = "/update")
    public ResponseEntity<String> updateMember(@RequestBody MemberBean memberBean) {
        memberService.update(memberBean.getId(),memberBean);
        return ResponseEntityBuilder.success()
                .message("更新成功")
                .build();
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Integer id) {
        memberService.delete(id);
        return ResponseEntityBuilder.success()
                .message("刪除成功")
                .build();
    }

}