package com.cyriii.dto;

import com.cyriii.enums.UserSexEnum;
import com.cyriii.enums.UserStatusEnum;
import com.cyriii.enums.UserTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserPageDTO extends PageDTO {

    @Schema(description = "用户昵称")
    private String nickName;

    @Schema(description = "用户手机")
    private String mobile;

    @Schema(description = "用户类型")
    private UserTypeEnum userType;

    @Schema(description = "性别")
    private UserSexEnum sex;

    @Schema(description = "用户状态")
    private UserStatusEnum status;

}
