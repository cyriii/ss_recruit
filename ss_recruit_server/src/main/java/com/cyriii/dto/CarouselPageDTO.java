package com.cyriii.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CarouselPageDTO extends PageDTO{

    @Schema(description = "分类名称")
    private String name;

    @Schema(description = "显示状态", example = "1")
    public Integer display;

}
