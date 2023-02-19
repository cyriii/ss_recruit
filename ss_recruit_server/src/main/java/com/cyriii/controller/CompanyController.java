package com.cyriii.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cyriii.common.R;
import com.cyriii.dto.CompanyPageDTO;
import com.cyriii.service.CompanyService;
import com.cyriii.vo.CompanyVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "公司信息")
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Operation(summary = "获取公司列表", description = "招聘人员关联公司时使用，只展示审核通过状态的")
    @GetMapping("/list")
    public R displayList() {
        return R.ok(companyService.displayList());
    }

    @PostMapping("/page")
    @Operation(summary = "获取公司列表（分页）")
    public R<IPage<CompanyVO>> page(@Validated @RequestBody CompanyPageDTO companyPageDTO) {
        IPage<CompanyVO> page = companyService.page(companyPageDTO);
        return R.ok(page);
    }

//    public R save(@RequestBody CompanyPageDTO ) {
//
//    }

}
