package com.cyriii.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.cyriii.common.R;
import com.cyriii.dto.CategorySaveDTO;
import com.cyriii.dto.CategoryUpdateDTO;
import com.cyriii.service.CategoryService;
import com.cyriii.vo.CategoryVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "分类信息")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "获取分类信息树型菜单", description = "首页使用")
    @SaIgnore
    @PostMapping("/tree")
    public R<CategoryVO> listWithTree() {
        return R.ok(categoryService.listWithTree());
    }

    @Operation(summary = "分类信息新增")
    @SaIgnore
    @PostMapping("/save")
    public R save(@RequestBody CategorySaveDTO categorySaveDTO) {
        categoryService.save(categorySaveDTO);
        return R.ok();
    }

    @Operation(summary = "分类信息更新")
    @PostMapping("/update")
    public R update(@RequestBody CategoryUpdateDTO categoryUpdateDTO) {
        categoryService.update(categoryUpdateDTO);
        return R.ok();
    }

    @Operation(summary = "分类信息删除")
    @PostMapping("/del/{id}")
    public R delete(@PathVariable Long id) {
        categoryService.delById(id);
        return R.ok();
    }

}
