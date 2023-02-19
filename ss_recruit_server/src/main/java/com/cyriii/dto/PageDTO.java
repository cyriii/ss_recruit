package com.cyriii.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PageDTO {
    @Schema(description = "当前页", example = "1")
    @NotNull(message = "分页参数不能为空")
    @Min(value = 1, message = "分页参数不能小于1")
    private Integer pageNo;

    @Schema(description = "每页条数", example = "10")
    @NotNull(message = "分页参数不能为空")
    @Min(value = 1, message = "分页参数不能小于1")
    private Integer pageSize;
}
