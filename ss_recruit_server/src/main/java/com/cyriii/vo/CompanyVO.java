package com.cyriii.vo;

import com.cyriii.enums.CompanyStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class CompanyVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @Schema(description = "公司名称")
    private String name;

    /**
     * 统一社会信用代码
     */
    @Schema(description = "统一社会信用代码")
    private String companyCode;

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

    /**
     * 状态
     */
    @Schema(description = "公司状态")
    private CompanyStatusEnum status;

    @Schema(description = "城市id")
    private Long crityId;

    @Schema(description = "创建日期")
    private Date createTime;
}
