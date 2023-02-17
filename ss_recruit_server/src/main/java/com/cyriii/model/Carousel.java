package com.cyriii.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 轮播图信息
 */
@Data
public class Carousel {
    @TableId
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
     * 创建人id
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer deleted;
}
