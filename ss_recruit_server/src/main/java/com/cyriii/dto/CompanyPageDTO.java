package com.cyriii.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CompanyPageDTO extends PageDTO{

    @Schema(description = "公司名称", example = "阿里")
    private String name;

    @Schema(description = "公司状态")
    private Integer status;
}
