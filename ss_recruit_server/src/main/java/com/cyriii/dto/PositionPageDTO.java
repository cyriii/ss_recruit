package com.cyriii.dto;

import com.cyriii.enums.FlowStatusEnum;
import com.cyriii.enums.PositionSourceEnum;
import com.cyriii.enums.WorkAgeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PositionPageDTO extends PageDTO {

    @Schema(description = "标题")
    private String title;

    @Schema(description = "招聘主体：1.企业，2.个人", example = "1")
    private PositionSourceEnum source;

    private Long companyId;

    @Schema(description = "行业id")
    private Long categoryId;

    @Schema(description = "所属地点id")
    private Long areaId;

    @Schema(description = "工作经历")
    private WorkAgeEnum workAge;

    @Schema(description = "审批状态")
    private FlowStatusEnum flowStatusEnum;
}
