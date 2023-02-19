package com.cyriii.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyriii.common.R;
import com.cyriii.dto.CarouseUpdateDTO;
import com.cyriii.dto.CarouselPageDTO;
import com.cyriii.dto.CarouselSaveDTO;
import com.cyriii.model.Carousel;
import com.cyriii.vo.CarouselVO;

import java.util.List;

public interface CarouselService extends IService<Carousel> {

    List<CarouselVO> displayList();

    IPage<CarouselVO> page(CarouselPageDTO carouselPageDTO);

    void delById(Long id);

    void save(CarouselSaveDTO carouselSaveDTO);

    void update(CarouseUpdateDTO carouseUpdateDTO);
}
