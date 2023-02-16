package com.cyriii.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.Getter;

@Getter
public enum UserTypeEnum {
    USER("1", "招聘者"),
    BOSS("2", "老板");

    @JsonValue
    @EnumValue
    private String code;

    private String desc;

    UserTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
