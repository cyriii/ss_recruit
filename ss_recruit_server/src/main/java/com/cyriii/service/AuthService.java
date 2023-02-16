package com.cyriii.service;

import com.cyriii.dto.UserLoginDTO;
import com.cyriii.vo.UserVO;

public interface AuthService {

    /**
     * 获取验证码
     * @param mobileNum
     * @return
     */
    String sendSmsCode(String mobileNum);

    /**
     * 用户注册
     *
     * @param userLoginDTO
     */
    UserVO login(UserLoginDTO userLoginDTO);
}
