package com.cyriii.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyriii.dto.CategorySaveDTO;
import com.cyriii.dto.CategoryUpdateDTO;
import com.cyriii.exception.BusinessException;
import com.cyriii.mapper.CategoryMapper;
import com.cyriii.model.Category;
import com.cyriii.service.CategoryService;
import com.cyriii.vo.CategoryVO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    @Cacheable(value = "ss:recruit:category", key = "'tree'")
    public List<CategoryVO> listWithTree() {
        List<Category> categories = this.lambdaQuery().list();
        List<CategoryVO> list = categories.stream().map(item -> BeanUtil.copyProperties(item, CategoryVO.class)).collect(Collectors.toList());
        // 父节点
        List<CategoryVO> rootList = list.stream().filter(item -> item.getPId().longValue() == 0).collect(Collectors.toList());
        Map<Long, CategoryVO> map = list.parallelStream().collect(Collectors.toMap(CategoryVO::getId, Function.identity()));
        list.stream().filter(item -> item.getId().longValue() != 0).forEach(item -> {
            CategoryVO categoryVO = map.get(item.getPId());
            if (Objects.nonNull(categoryVO)) {
                categoryVO.getChildren().add(item);
            }
        });
        return rootList;
    }

    @Override
    @CacheEvict(value = "ss:recruit:category", key = "'tree'")
    public void save(CategorySaveDTO categorySaveDTO) {
        // 查询同分类下是否存在该名称

        Long count = this.lambdaQuery().eq(Category::getPId, categorySaveDTO.getPId()).eq(Category::getName, categorySaveDTO.getName()).count();
        if (count > 0) {
            throw new BusinessException("该分类下已包含[" + categorySaveDTO.getName() + "]");
        }
        Category category = BeanUtil.copyProperties(categorySaveDTO, Category.class);
        this.save(category);
    }

    @Override
    @CacheEvict(value = "ss:recruit:category", key = "'tree'")
    public void update(CategoryUpdateDTO categoryUpdateDTO) {
        Category category = BeanUtil.copyProperties(categoryUpdateDTO, Category.class);
        this.updateById(category);
    }

    @Override
    @CacheEvict(value = "ss:recruit:category", key = "'tree'")
    public void delById(Long id) {
        // TODO 先查询是否有在使用

        this.removeById(id);
    }
}
