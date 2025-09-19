package tw.edu.ntub.imd.birc.practice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ntub.imd.birc.practice.bean.UserAccountBean;
import tw.edu.ntub.imd.birc.practice.service.UserAccountService;
import tw.edu.ntub.imd.birc.practice.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.practice.util.http.ResponseEntityBuilder;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class UserAccountController {
    private final UserAccountService userAccountService;

    @PostMapping(path = "")
    public ResponseEntity<String> getLoginUser(@Valid UserAccountBean userAccountBean,
                                               BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        userAccountService.registerUserAccount(userAccountBean);
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .build();
    }
}
