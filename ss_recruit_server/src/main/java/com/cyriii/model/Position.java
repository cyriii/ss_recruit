package com.cyriii.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 招聘信息
 */
@Data
public class Position {

    @TableId
    private Long id;

    /**
     * 所属公司id
     */
    private Long companyId;

    /**
     * 标题
     */
    private String title;

    /**
     * 岗位内容
     */
    private String content;

    /**
     * 最小薪资
     */
    private Integer salaryMin;

    /**
     * 最大薪资
     */
    private Integer salaryMax;

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
     * 是否展示
     */
    private Integer show;

    /**
     * 是否删除
     */
    private Integer deleted;

}
