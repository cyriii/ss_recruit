package com.cyriii.dto;

import com.cyriii.enums.UserSexEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserUpdateDTO {

    @Schema(description = "用户id")
    private Long id;

    private String nickName;

    private String header;

    private UserSexEnum sex;

}
