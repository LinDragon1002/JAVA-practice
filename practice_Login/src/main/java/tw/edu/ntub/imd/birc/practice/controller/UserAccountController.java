package tw.edu.ntub.imd.birc.practice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.birc.practice.bean.UserAccountBean;
import tw.edu.ntub.imd.birc.practice.config.util.SecurityUtils;
import tw.edu.ntub.imd.birc.practice.exception.BircException;
import tw.edu.ntub.imd.birc.practice.service.UserAccountService;
import tw.edu.ntub.imd.birc.practice.util.http.BindingResultUtils;
import tw.edu.ntub.imd.birc.practice.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.birc.practice.util.json.array.ArrayData;
import tw.edu.ntub.imd.birc.practice.util.json.object.ObjectData;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class UserAccountController {
    private final UserAccountService userAccountService;

    // 註冊新用戶
    @PostMapping(path = "/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserAccountBean userAccountBean,
                                               BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);

        try {
            userAccountService.registerUserAccount(userAccountBean);
            return ResponseEntityBuilder.success()
                    .message("註冊成功")
                    .build();
        } catch (BircException e) {
            return ResponseEntityBuilder.error()
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping(path = "/update")
    public ResponseEntity<String> updatePassword(@Valid @RequestParam String username,
                                                 @Valid @RequestParam String currentPassword,
                                                 @Valid @RequestParam String newPassword) {
        try {
            userAccountService.updatePassword(username,currentPassword, newPassword);
            return ResponseEntityBuilder.success()
                    .message("更改成功")
                    .build();
        } catch (Exception e) {
            return ResponseEntityBuilder.error()
                    .message(e.getMessage())
                    .build();
        }
    }

    // 查詢用戶（需要登入）
    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = "")
    public ResponseEntity<String> getLoginUser(@PathVariable (name = "account") String account) {
        List<UserAccountBean> users = userAccountService.findByAccount(account);

        ArrayData arrayData = new ArrayData();
        for (UserAccountBean user : users) {
            ObjectData objectData = arrayData.addObject();
            objectData.add("id", user.getSno());
            objectData.add("account", user.getAccount());
            objectData.add("email", user.getEmail());
        }

        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(arrayData)
                .build();
    }

    // 獲取當前登入用戶資訊
    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = "/current")
    public ResponseEntity<String> getCurrentUser() {
        try {
            // 使用 SecurityUtils 獲取當前登入用戶
            String currentUsername = SecurityUtils.getLoginUserAccount();
            List<UserAccountBean> users = userAccountService.findByAccount(currentUsername);

            if (users.isEmpty()) {
                return ResponseEntityBuilder.error()
                        .message("找不到當前用戶資訊")
                        .build();
            }

            UserAccountBean currentUser = users.get(0);
            ObjectData objectData = new ObjectData();
            objectData.add("id", currentUser.getSno());
            objectData.add("account", currentUser.getAccount());
            objectData.add("email", currentUser.getEmail());

            return ResponseEntityBuilder.success()
                    .message("獲取用戶資訊成功")
                    .data(objectData)
                    .build();
        } catch (Exception e) {
            return ResponseEntityBuilder.error()
                    .message("未登入或登入已過期")
                    .build();
        }
    }
}
