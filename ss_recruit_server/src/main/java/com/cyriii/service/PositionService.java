package com.cyriii.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyriii.dto.PositionPageDTO;
import com.cyriii.dto.PositionUpdateStatusDTO;
import com.cyriii.model.Position;
import com.cyriii.vo.PositionVO;

import java.util.List;

public interface PositionService extends IService<Position> {
    IPage<PositionVO> adminPage(PositionPageDTO positionPageDTO);

    void updateStatus(PositionUpdateStatusDTO positionUpdateStatusDTO);
}
