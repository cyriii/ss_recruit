package com.cyriii.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cyriii.common.R;
import com.cyriii.dto.CarouseUpdateDTO;
import com.cyriii.dto.CarouselPageDTO;
import com.cyriii.dto.CarouselSaveDTO;
import com.cyriii.service.CarouselService;
import com.cyriii.vo.CarouselVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "轮播图信息")
@RestController
@RequestMapping("/carouse")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @Operation(summary = "轮播图列表", description = "首页使用")
    @GetMapping("/display/list")
    public R<CarouselVO> displayList() {
        return R.ok(carouselService.displayList());
    }

    /**
     * 轮播图分页查询
     * @return
     */
    @Operation(summary = "轮播图列表（分页）", description = "管理端使用，可新增、修改、删除、是否展示")
    @PostMapping("/page")
    public R<IPage<CarouselVO>> page(@Validated @RequestBody CarouselPageDTO carouselPageDTO) {
        return R.ok(carouselService.page(carouselPageDTO));
    }

    @Operation(summary = "轮播图新增", description = "后台使用")
    @PostMapping("/save")
    public R save(@Validated @RequestBody CarouselSaveDTO carouselSaveDTO) {
        carouselService.save(carouselSaveDTO);
        return R.ok();
    }

    @Operation(summary = "轮播图修改", description = "后台使用")
    @PostMapping("/update")
    public R update(@Validated @RequestBody CarouseUpdateDTO carouseUpdateDTO) {
        carouselService.update(carouseUpdateDTO);
        return R.ok();
    }

    @Operation(summary = "轮播图删除", description = "后台使用")
    @PostMapping("/del/{id}")
    public R delete(@PathVariable Long id) {
        carouselService.delById(id);
        return R.ok();
    }

}
