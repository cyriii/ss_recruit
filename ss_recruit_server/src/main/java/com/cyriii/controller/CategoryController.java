package com.cyriii.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.cyriii.common.R;
import com.cyriii.dto.CategorySaveDTO;
import com.cyriii.dto.CategoryUpdateDTO;
import com.cyriii.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "分类信息")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @SaIgnore
    @PostMapping("/tree")
    public R listWithTree() {
        return R.ok(categoryService.listWithTree());
    }

    @SaIgnore
    @PostMapping("/save")
    public R save(@RequestBody CategorySaveDTO categorySaveDTO) {
        categoryService.save(categorySaveDTO);
        return R.ok();
    }

    @PostMapping("/update")
    public R update(@RequestBody CategoryUpdateDTO categoryUpdateDTO) {
        categoryService.update(categoryUpdateDTO);
        return R.ok();
    }

    @PostMapping("/del/{id}")
    public R delete(@PathVariable Long id) {
        categoryService.delById(id);
        return R.ok();
    }

}
