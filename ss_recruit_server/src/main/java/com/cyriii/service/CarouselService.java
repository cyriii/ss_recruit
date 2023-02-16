package com.cyriii.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyriii.dto.CarouselPageDTO;
import com.cyriii.model.Carousel;
import com.cyriii.vo.CarouselVO;

import java.util.List;

public interface CarouselService extends IService<Carousel> {

    List<CarouselVO> showList();

    IPage<CarouselVO> page(CarouselPageDTO carouselPageDTO);
}
