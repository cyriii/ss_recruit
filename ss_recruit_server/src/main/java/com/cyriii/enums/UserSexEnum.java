package com.cyriii.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserSexEnum {

    UNKNOW("0", "保密"),
    MAN("1", "男"),
    WOMAN("1", "女");

    @JsonValue
    @EnumValue
    private String code;

    private String desc;

    UserSexEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
