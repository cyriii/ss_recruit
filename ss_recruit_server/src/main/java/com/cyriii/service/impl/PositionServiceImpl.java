package com.cyriii.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyriii.mapper.PositionMapper;
import com.cyriii.model.Position;
import com.cyriii.service.PositionService;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService {
}
