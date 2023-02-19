package com.cyriii.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum PositionSourceEnum {
    COMPANY("1", "公司"),
    PEOPLE("2", "个人");

    @JsonValue
    @EnumValue
    private String code;

    private String desc;

    PositionSourceEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
