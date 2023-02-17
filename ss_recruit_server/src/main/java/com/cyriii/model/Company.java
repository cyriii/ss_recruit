package com.cyriii.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 公司信息
 */
@Data
public class Company {

    @TableId
    private Long id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 公司logo地址
     */
    private String logoUrl;

    /**
     * 公司简介
     */
    private String description;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建人id
     */
    private Long createUserId;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 更新日期
     */
    private Date updateTime;

    /**
     * 逻辑删除标志位
     */
    private Integer deleted;

}
