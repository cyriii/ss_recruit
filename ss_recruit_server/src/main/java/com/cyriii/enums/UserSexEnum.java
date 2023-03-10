package com.cyriii.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public enum UserSexEnum {

    @Schema(description = "保密")
    UNKNOW("0", "保密"),
    @Schema(description = "男")
    MAN("1", "男"),
    @Schema(description = "女")
    WOMAN("2", "女");

    @JsonValue
    @EnumValue
    private String code;

    private String desc;

    UserSexEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
