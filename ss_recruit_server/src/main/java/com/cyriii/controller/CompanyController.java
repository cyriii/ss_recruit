package com.cyriii.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cyriii.common.R;
import com.cyriii.dto.CompanyPageDTO;
import com.cyriii.model.Company;
import com.cyriii.service.CompanyService;
import com.cyriii.vo.CompanyVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "公司信息")
@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Operation(summary = "获取公司列表", description = "招聘人员关联公司时使用，只展示审核通过状态的")
    @GetMapping("/show/list")
    public R showList() {
        return R.ok(companyService.showList());
    }

    @Operation(summary = "获取公司列表（分页）")
    public R page(@Validated @RequestBody CompanyPageDTO companyPageDTO) {
        IPage<CompanyVO> companyVOIPage = companyService.page(companyPageDTO);
        return R.ok(companyVOIPage);
    }



}
