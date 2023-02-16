package com.cyriii.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyriii.dto.CategorySaveDTO;
import com.cyriii.dto.CategoryUpdateDTO;
import com.cyriii.model.Category;
import com.cyriii.vo.CategoryVO;

import java.util.List;

public interface CategoryService extends IService<Category> {
    List<CategoryVO> listWithTree();

    void save(CategorySaveDTO categorySaveDTO);

    void update(CategoryUpdateDTO categoryUpdateDTO);

    void delById(Long id);
}
