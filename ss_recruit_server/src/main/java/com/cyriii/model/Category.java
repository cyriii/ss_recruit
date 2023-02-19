package com.cyriii.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 行业分类信息
 */
@Data
public class Category {

    @TableId
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 父id
     */
    private Long pId;

    /**
     * 层级
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer level;

    /**
     * 排序
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer sort;

    /**
     * 是否展示
     */
    private Integer display;

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
     * 逻辑删除
     */
    private Integer deleted;


}
