package com.cyriii.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarouselSaveDTO {

    /**
     * 图片名称
     */
    @Schema(description = "图片名称")
    @NotBlank(message = "图片名称不能为空")
    private String name;

    /**
     * 图片地址
     */
    @NotBlank(message = "图片地址不能为空")
    @Schema(description = "图片地址")
    private String url;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String memo;

    /**
     * 是否展示
     */
    @NotNull(message = "是否展示字段不能为空")
    @Schema(description = "是否展示")
    private Integer display;

    /**
     * 排序
     */
    @Schema(description = "排序字段")
    private Integer sort;

}
