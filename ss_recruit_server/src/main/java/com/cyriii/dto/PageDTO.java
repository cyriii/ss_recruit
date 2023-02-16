package com.cyriii.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PageDTO {
    @NotNull(message = "分页参数不能为空")
    private Integer pageNo;

    @NotNull(message = "分页参数不能为空")
    private Integer pageSize;
}
