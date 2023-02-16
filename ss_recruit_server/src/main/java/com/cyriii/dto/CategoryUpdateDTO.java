package com.cyriii.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryUpdateDTO {

    @NotBlank(message = "分类名称不能为空")
    private String name;

    @NotBlank(message = "父id不能为空")
    private Long pId;

    private Integer level;

    private Integer sort;

}
