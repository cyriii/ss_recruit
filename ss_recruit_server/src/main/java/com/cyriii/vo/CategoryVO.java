package com.cyriii.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryVO {

    @Schema(description = "行业分类id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @Schema(description = "行业名称")
    private String name;

    @Schema(description = "父id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long pId;

    private Integer level;

    private Integer sort;

    @Schema(description = "是否展示（0不展示，1展示）", example = "1")
    private Integer display;

    @Schema(description = "子集合")
    private List<CategoryVO> children = new ArrayList<>();
}
