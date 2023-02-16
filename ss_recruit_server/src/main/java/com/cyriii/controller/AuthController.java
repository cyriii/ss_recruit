package com.cyriii.controller;

import com.cyriii.common.R;
import com.cyriii.dto.UserLoginDTO;
import com.cyriii.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户认证")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Operation(summary = "发送手机验证码接口")
    @Parameter(name = "mobilNum", description = "手机号", required = true)
    @GetMapping("/send-sms/{mobilNum}")
    public R sendSmsCode(@PathVariable String mobilNum) {
        authService.sendSmsCode(mobilNum);
        return R.ok();
    }

    @Operation(summary = "用户登录接口")
    @PostMapping("/login")
    public R login(@Validated @RequestBody UserLoginDTO userLoginDTO) {
        return R.ok(authService.login(userLoginDTO));
    }

}
