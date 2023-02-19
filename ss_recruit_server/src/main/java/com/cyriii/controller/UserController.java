package com.cyriii.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.cyriii.common.R;
import com.cyriii.dto.UserPageDTO;
import com.cyriii.dto.UserUpdateDTO;
import com.cyriii.dto.UserUpdateStatusDTO;
import com.cyriii.service.UserService;
import com.cyriii.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户信息")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "获取用户信息", description = "需要在header中设置ss-token")
    @PostMapping("/info")
    public R<UserVO> getInfo() {
        Long userId = StpUtil.getLoginIdAsLong();
        UserVO userVO = userService.getById(userId);
        return R.ok(userVO);
    }

    @Operation(summary = "更新用户信息", description = "需要在header中设置ss-token")
    @PostMapping("/update")
    public R updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        userService.updateUser(userUpdateDTO);
        return R.ok();
    }


    @Operation(summary = "用户信息列表（分页）")
    @PostMapping("/page")
    public R<UserVO> page(@Validated @RequestBody UserPageDTO userPageDTO) {
        return R.ok(userService.page(userPageDTO));
    }

    @Operation(summary = "更新用户状态")
    @PostMapping("/update/status")
    public R updateStatus(@RequestBody UserUpdateStatusDTO userUpdateStatusDTO) {
        userService.updateStatus(userUpdateStatusDTO);
        return R.ok();
    }
}
