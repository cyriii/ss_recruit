package com.cyriii.vo;

import io.swagger.v3.oas.annotations.media.Schema;

public class CompanyVO {

    private Long id;

    @Schema(description = "公司名称")
    private String name;

    /**
     * 公司logo地址
     */
    @Schema(description = "公司logo地址")
    private String logoUrl;

    /**
     * 公司简介
     */
    @Schema(description = "公司简介")
    private String description;

    /**
     * 公司地址
     */
    @Schema(description = "公司地址")
    private String address;
}
