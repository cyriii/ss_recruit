package com.cyriii.vo;

import com.cyriii.enums.UserSexEnum;
import com.cyriii.enums.UserStatusEnum;
import com.cyriii.enums.UserTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserVO {

    @Schema(description = "用户id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @Schema(description = "用户手机")
    private String mobile;

    private UserTypeEnum userType;

    @Schema(description = "用户昵称")
    private String nickName;

    @Schema(description = "用户头像")
    private String header;

    @Schema(description = "用户性别")
    private UserSexEnum sex;

    @Schema(description = "用户状态")
    private UserStatusEnum status;

    @Schema(description = "用户token，登录接口返回")
    private String token;

}
