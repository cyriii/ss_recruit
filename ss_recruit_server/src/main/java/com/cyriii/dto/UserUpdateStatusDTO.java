package com.cyriii.dto;

import com.cyriii.enums.UserStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserUpdateStatusDTO {

    @Schema(description = "用户id")
    private Long id;

    @Schema(description = "用户状态")
    private UserStatusEnum userStatusEnum;

}
