package com.cyriii.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class CarouselVO {

    @Schema(description = "轮播图id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 图片名称
     */
    @Schema(description = "轮播图名称")
    private String name;

    /**
     * 图片地址
     */
    @Schema(description = "轮播图地址")
    private String url;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String memo;

    /**
     * 是否展示
     */
    @Schema(description = "是否展示")
    private Integer display;

    /**
     * 排序
     */
    @Schema(description = "排序字段")
    private Integer sort;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

}
