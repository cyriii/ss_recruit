package com.cyriii.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyriii.dto.PositionPageDTO;
import com.cyriii.dto.PositionUpdateStatusDTO;
import com.cyriii.mapper.PositionMapper;
import com.cyriii.model.Position;
import com.cyriii.service.PositionService;
import com.cyriii.vo.PositionVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService {

    @Override
    public IPage<PositionVO> adminPage(PositionPageDTO positionPageDTO) {
        Page<Position> page = this.lambdaQuery()
                .like(StringUtils.isNotBlank(positionPageDTO.getTitle()), Position::getTitle, positionPageDTO.getTitle())
                .eq(Objects.nonNull(positionPageDTO.getSource()), Position::getSource, positionPageDTO.getSource())
                .eq(Objects.nonNull(positionPageDTO.getCompanyId()), Position::getCompanyId, positionPageDTO.getCompanyId())
                .eq(Objects.nonNull(positionPageDTO.getCategoryId()), Position::getCategoryId, positionPageDTO.getCategoryId())
                .eq(Objects.nonNull(positionPageDTO.getAreaId()), Position::getAreaId, positionPageDTO.getAreaId())
                .le(Objects.nonNull(positionPageDTO.getWorkAge()), Position::getWorkAge, positionPageDTO.getWorkAge())
                .eq(Objects.nonNull(positionPageDTO.getFlowStatusEnum()), Position::getStatus, positionPageDTO.getFlowStatusEnum())
                .page(new Page<>(positionPageDTO.getPageNo(), positionPageDTO.getPageSize()));
        return page.convert(item -> BeanUtil.copyProperties(item, PositionVO.class));
    }

    @Override
    public void updateStatus(PositionUpdateStatusDTO positionUpdateStatusDTO) {
        Position position = BeanUtil.copyProperties(positionUpdateStatusDTO, Position.class);
        this.updateById(position);
    }
}
