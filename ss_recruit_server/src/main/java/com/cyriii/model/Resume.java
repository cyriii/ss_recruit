package com.cyriii.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class Resume {

    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 专业能力
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String ability;

    /**
     * 学历信息
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String qualifications;

    /**
     * 工作经历
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String workExperience;

    /**
     * 项目经历
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String projectExperience;

    /**
     * 自我评价
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String selfEvaluation;

    /**
     * 简历附件
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String annexUrl;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

}
