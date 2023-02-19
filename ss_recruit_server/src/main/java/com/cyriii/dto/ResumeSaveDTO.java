package com.cyriii.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ResumeSaveDTO {

    /**
     * 专业能力
     */
    @Schema(description = "专业能力")
    private String ability;

    /**
     * 学历信息
     */
    @Schema(description = "学历信息")
    private String qualifications;

    /**
     * 工作经历
     */
    @Schema(description = "工作经历")
    private String workExperience;

    /**
     * 项目经验
     */
    @Schema(description = "项目经历")
    private String projectExperience;

    /**
     * 自我评价
     */
    @Schema(description = "自我评级")
    private String selfEvaluation;

    /**
     * 简历附件地址
     */
    @Schema(description = "简历附件地址")
    private String annexUrl;

}
