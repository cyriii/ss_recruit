package com.cyriii.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategorySaveDTO {

    @Schema(description = "分类名称")
    @NotBlank(message = "分类名称不能为空")
    private String name;

    @Schema(description = "父节点id")
    @NotNull(message = "父id不能为空")
    private Long pId;

    @Schema(description = "当前层及")
    private Integer level;

    @Schema(description = "排序字段")
    private Integer sort;


    @Schema(description = "是否展示（0：否，1：是）")
    @NotNull(message = "是否展示字段不能为空")
    private Integer display;

}
