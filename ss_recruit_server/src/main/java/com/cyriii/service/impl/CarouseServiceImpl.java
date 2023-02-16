package com.cyriii.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyriii.dto.CarouselPageDTO;
import com.cyriii.mapper.CarouselMapper;
import com.cyriii.model.Carousel;
import com.cyriii.service.CarouselService;
import com.cyriii.vo.CarouselVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CarouseServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {

    @Override
    public List<CarouselVO> showList() {
        List<Carousel> list = this.lambdaQuery().eq(Carousel::getShow, 1).orderByAsc(Carousel::getSort).list();
        List<CarouselVO> carouselVOList = list.stream().map(item -> BeanUtil.copyProperties(item, CarouselVO.class)).collect(Collectors.toList());
        return carouselVOList;
    }

    @Override
    public IPage<CarouselVO> page(CarouselPageDTO carouselPageDTO) {
        Page<Carousel> page = this.lambdaQuery()
                .eq(Objects.nonNull(carouselPageDTO.getShow()), Carousel::getShow, carouselPageDTO.getShow())
                .like(StringUtils.isNotBlank(carouselPageDTO.getName()), Carousel::getName, carouselPageDTO.getName())
                .orderByDesc(Carousel::getCreateTime)
                .page(new Page<>(carouselPageDTO.getPageNo(), carouselPageDTO.getPageSize()));

        IPage<CarouselVO> iPage = page.convert(item -> BeanUtil.copyProperties(item, CarouselVO.class));
        return iPage;
    }
}
