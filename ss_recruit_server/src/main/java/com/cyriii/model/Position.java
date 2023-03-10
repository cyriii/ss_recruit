package com.cyriii.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.cyriii.enums.FlowStatusEnum;
import com.cyriii.enums.PositionSourceEnum;
import com.cyriii.enums.WorkAgeEnum;
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
     * 招聘信息所属
     */
    private PositionSourceEnum source;

    /**
     * 所属公司id
     */
    private Long companyId;

    /**
     * 所属个人id
     */
    private Long userId;

    /**
     * 行业id
     */
    private Long categoryId;

    /**
     * 标题
     */
    private String title;

    /**
     * 岗位内容
     */
    private String content;

    /**
     * 工作地点id
     */
    private String areaId;

    /**
     * 工作地点
     */
    private String address;

    /**
     * 最小薪资（单位元）
     */
    private Integer salaryMin;

    /**
     * 最大薪资（单位元）
     */
    private Integer salaryMax;

    /**
     * 学历
     */
    private Integer education;

    /**
     * 工作经验
     */
    private WorkAgeEnum workAge;

    /**
     * 联系电话
     */
    private Integer mobile;

    /**
     * 电子邮箱
     */
    private String emailAddress;

    /**
     * 审批状态
     */
    private FlowStatusEnum status;

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
     * 是否删除
     */
    private Integer deleted;

}
