package com.cyriii.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyriii.mapper.AreaMapper;
import com.cyriii.model.Area;
import com.cyriii.service.AreaService;
import com.cyriii.vo.AreaVO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

    @Override
    @Cacheable(value = "ss:recruit:area", key = "'tree'")
    public List<AreaVO> listWithTree() {
        List<Area> areas = this.lambdaQuery().list();
        List<AreaVO> list = areas.stream().map(item -> BeanUtil.copyProperties(item, AreaVO.class)).collect(Collectors.toList());

        List<AreaVO> rootList = list.stream().filter(item -> item.getPId().intValue() == 0).collect(Collectors.toList());
        Map<Long, AreaVO> map = list.parallelStream().collect(Collectors.toMap(AreaVO::getId, Function.identity()));
        list.stream().filter(item -> item.getId().longValue() != 0).forEach(item -> {
            AreaVO areaVO = map.get(item.getPId());
            if (Objects.nonNull(areaVO)) {
                areaVO.getChildren().add(item);
            }
        });

        return rootList;
    }
}
