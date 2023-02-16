package com.cyriii.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.cyriii.common.R;
import com.cyriii.dto.UserPageDTO;
import com.cyriii.dto.UserUpdateDTO;
import com.cyriii.service.UserService;
import com.cyriii.vo.UserVO;
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

    @PostMapping("/info")
    public R getUserById() {
        Long userId = StpUtil.getLoginIdAsLong();
        UserVO userVO = userService.getById(userId);
        return R.ok(userVO);
    }

    @PostMapping("/update")
    public R updateUser(UserUpdateDTO userUpdateDTO) {
        userService.updateUser(userUpdateDTO);
        return R.ok();
    }


    @PostMapping("/page")
    public R page(@Validated @RequestBody UserPageDTO userPageDTO) {
        return R.ok(userService.page(userPageDTO));
    }

}
