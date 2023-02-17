package com.cyriii.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.cyriii.enums.UserSexEnum;
import com.cyriii.enums.UserTypeEnum;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    @TableId
    private Long id;

    private String mobile;

    private UserTypeEnum userType;

    private String nickName;

    private String header;

    private UserSexEnum sex;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

}
