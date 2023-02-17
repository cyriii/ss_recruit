package com.cyriii.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cyriii.common.R;
import com.cyriii.dto.CarouselPageDTO;
import com.cyriii.service.CarouselService;
import com.cyriii.vo.CarouselVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "轮播图信息")
@RestController
@RequestMapping("/carouse")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @Operation(summary = "轮播图列表", description = "首页使用")
    @GetMapping("/show/list")
    public R<CarouselVO> showList() {
        return R.ok(carouselService.showList());
    }

    /**
     * 轮播图分页查询
     * @return
     */
    @Operation(summary = "轮播图列表（分页）", description = "管理端使用")
    @PostMapping("/page")
    public R<IPage<CarouselVO>> page(@Validated CarouselPageDTO carouselPageDTO) {
        return R.ok(carouselService.page(carouselPageDTO));
    }

}
