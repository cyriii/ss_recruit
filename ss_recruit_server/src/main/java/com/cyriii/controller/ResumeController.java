package com.cyriii.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.cyriii.common.R;
import com.cyriii.dto.ResumeSaveDTO;
import com.cyriii.service.ResumeService;
import com.cyriii.vo.ResumeVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "个人简历信息")
@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Operation(summary = "获取简历信息")
    @PostMapping("/info/{userId}")
    public R<ResumeVO> getInfo(@PathVariable Long userId) {
        return R.ok(resumeService.getByUserId(userId));
    }

    @Operation(summary = "个人简历新增/修改", description = "前台进行修改")
    @PostMapping("/save")
    public R saveOrUpdate(@RequestBody ResumeSaveDTO resumeSaveDTO) {
        resumeService.save(resumeSaveDTO);
        return R.ok();
    }

}
