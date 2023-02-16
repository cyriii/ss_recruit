package com.cyriii.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CarouselVO {

    private Long id;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 备注
     */
    private String memo;

    /**
     * 是否展示
     */
    private Boolean show;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createTime;

}
