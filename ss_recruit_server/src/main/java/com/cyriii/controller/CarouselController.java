package com.cyriii.controller;

import com.cyriii.common.R;
import com.cyriii.dto.CarouselPageDTO;
import com.cyriii.service.CarouselService;
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

    /**
     * 展示首页轮播图
     * @return
     */
    @GetMapping("/show/list")
    public R showList() {
        return R.ok(carouselService.showList());
    }

    /**
     * 轮播图分页查询
     * @return
     */
    @PostMapping("/page")
    public R page(@Validated CarouselPageDTO carouselPageDTO) {
        return R.ok(carouselService.page(carouselPageDTO));
    }

}
