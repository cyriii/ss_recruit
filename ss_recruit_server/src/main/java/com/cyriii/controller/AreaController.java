package com.cyriii.controller;

import com.cyriii.common.R;
import com.cyriii.service.AreaService;
import com.cyriii.vo.AreaVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "地区信息")
@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/tree")
    public R<AreaVO> tree() {
        return R.ok(areaService.listWithTree());
    }

}
