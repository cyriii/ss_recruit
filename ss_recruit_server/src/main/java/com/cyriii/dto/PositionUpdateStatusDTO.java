package com.cyriii.dto;

import com.cyriii.enums.FlowStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PositionUpdateStatusDTO {

    @NotNull(message = "招聘id不能为空")
    @Schema(description = "招聘信息id")
    private Long id;

    @NotNull(message = "招聘状态不能未空")
    @Schema(description = "审核状态")
    private FlowStatusEnum status;

}
