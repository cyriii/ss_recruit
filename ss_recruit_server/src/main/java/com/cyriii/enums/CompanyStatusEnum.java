package com.cyriii.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum CompanyStatusEnum {
    WAIT("0", "待审批"),
    PASS("1", "审批通过"),
    REJECT("2", "审批驳回");


    @JsonValue
    @EnumValue
    private String code;

    private String desc;


    CompanyStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
