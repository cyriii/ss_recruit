package com.cyriii.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyriii.common.R;
import com.cyriii.dto.CarouseUpdateDTO;
import com.cyriii.dto.CarouselPageDTO;
import com.cyriii.dto.CarouselSaveDTO;
import com.cyriii.mapper.CarouselMapper;
import com.cyriii.model.Carousel;
import com.cyriii.service.CarouselService;
import com.cyriii.vo.CarouselVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CarouseServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {

    @Override
    @Cacheable(value = "ss:recruit:carouse", key = "'list'")
    public List<CarouselVO> displayList() {
        List<Carousel> list = this.lambdaQuery().eq(Carousel::getDisplay, 1).orderByAsc(Carousel::getSort).list();
        List<CarouselVO> carouselVOList = list.stream().map(item -> BeanUtil.copyProperties(item, CarouselVO.class)).collect(Collectors.toList());
        return carouselVOList;
    }

    @Override
    public IPage<CarouselVO> page(@RequestBody CarouselPageDTO carouselPageDTO) {
        Page<Carousel> page = this.lambdaQuery()
                .eq(Objects.nonNull(carouselPageDTO.getDisplay()), Carousel::getDisplay, carouselPageDTO.getDisplay())
                .like(StringUtils.isNotBlank(carouselPageDTO.getName()), Carousel::getName, carouselPageDTO.getName())
                .orderByDesc(Carousel::getCreateTime)
                .page(new Page<>(carouselPageDTO.getPageNo(), carouselPageDTO.getPageSize()));

        IPage<CarouselVO> iPage = page.convert(item -> BeanUtil.copyProperties(item, CarouselVO.class));
        return iPage;
    }

    @Override
    public void save(CarouselSaveDTO carouselSaveDTO) {
        Carousel carousel = BeanUtil.copyProperties(carouselSaveDTO, Carousel.class);
        this.save(carousel);
    }

    @Override
    public void update(CarouseUpdateDTO carouseUpdateDTO) {
        Carousel carousel = BeanUtil.copyProperties(carouseUpdateDTO, Carousel.class);
        this.save(carousel);
    }

    @Override
    @CacheEvict(value = "ss:recruit:carouse", key = "'list'")
    public void delById(Long id) {
        this.removeById(id);
    }
}
