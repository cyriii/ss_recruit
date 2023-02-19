package com.cyriii.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cyriii.common.R;
import com.cyriii.dto.PositionPageDTO;
import com.cyriii.dto.PositionUpdateStatusDTO;
import com.cyriii.service.PositionService;
import com.cyriii.vo.PositionVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "招聘信息")
@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @Operation(summary = "分页获取所有招聘信息", description = "后台管理用")
    @PostMapping("/admin/page")
    public R<IPage<PositionVO>> page(@Validated @RequestBody PositionPageDTO positionPageDTO) {
        return R.ok(positionService.adminPage(positionPageDTO));
    }


    @Operation(summary = "招聘信息审核", description = "后台管理用")
    @PostMapping("/update/status")
    public R updateStatus(@Validated @RequestBody PositionUpdateStatusDTO positionUpdateStatusDTO) {
        positionService.updateStatus(positionUpdateStatusDTO);
        return R.ok();
    }


}
