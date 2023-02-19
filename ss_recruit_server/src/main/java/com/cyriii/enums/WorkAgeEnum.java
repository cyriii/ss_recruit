package com.cyriii.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum WorkAgeEnum {
    NONE("0", "经验不限"),
    ONE("1", "1-3年"),
    THREE("3", "3-5年"),
    FIVE("5", "5-10年"),
    TEN("10", "10年以上");

    @JsonValue
    @EnumValue
    private String code;

    private String desc;

    WorkAgeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
