package com.cyriii.vo;

import com.cyriii.enums.UserSexEnum;
import com.cyriii.enums.UserTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserVO {

    private Long id;

    private String mobile;

    private UserTypeEnum userType;

    private String nickName;

    private String header;

    private UserSexEnum sex;

    private Integer status;

    private String token;

}
