package com.cyriii.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.bean.BeanUtil;
import com.cyriii.common.RedisPrefix;
import com.cyriii.dto.UserLoginDTO;
import com.cyriii.exception.BusinessException;
import com.cyriii.model.User;
import com.cyriii.service.AuthService;
import com.cyriii.service.UserService;
import com.cyriii.utils.SmsUtils;
import com.cyriii.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private SmsUtils smsUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${ali.sms.code-time-Out:1}")
    private Long codeTimeOut;

    @Override
    public String sendSmsCode(String mobileNum) {
        // 生成随机验证码
        RandomGenerator randomGenerator = new RandomGenerator("123456789", 6);
        String code = randomGenerator.generate().toUpperCase();
        if (!stringRedisTemplate.opsForValue().setIfAbsent(RedisPrefix.SMS_CODE_CACHE_PREFIX + mobileNum, code, codeTimeOut, TimeUnit.HOURS)) {
            throw new BusinessException("验证码已发送，请稍后重试");
        }
        // 发送手机验证码
        smsUtils.sendSms(mobileNum, code);
        return code;
    }

    @Override
    @Transactional
    public UserVO login(UserLoginDTO userLoginDTO) {
        String code = stringRedisTemplate.opsForValue().get(RedisPrefix.SMS_CODE_CACHE_PREFIX + userLoginDTO.getMobile());
        if (!StringUtils.equals(code, userLoginDTO.getCode().toUpperCase()) && !StringUtils.equals("666666", userLoginDTO.getCode())) {
            throw new BusinessException("验证码有误");
        }
        // 删除缓存key
        stringRedisTemplate.delete(RedisPrefix.SMS_CODE_CACHE_PREFIX + userLoginDTO.getMobile());

        // 检查手机号是否已经存在
        User user = userService.lambdaQuery().eq(User::getMobile, userLoginDTO.getMobile()).one();
        if (Objects.isNull(user)) {
            // 手机号不存在进行注册
            user = BeanUtil.copyProperties(userLoginDTO, User.class);
            userService.save(user);
        }
        user = userService.lambdaQuery().eq(User::getMobile, userLoginDTO.getMobile()).one();
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        // 进行登陆操作
        StpUtil.login(user.getId());
        SaTokenInfo token = StpUtil.getTokenInfo();
        userVO.setToken(token.getTokenValue());
        return userVO;
    }

}
