package com.cyriii.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyriii.dto.CompanyPageDTO;
import com.cyriii.mapper.CompanyMapper;
import com.cyriii.model.Company;
import com.cyriii.service.CompanyService;
import com.cyriii.vo.CompanyVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Override
    public List<CompanyVO> displayList() {
        List<Company> list = this.lambdaQuery().eq(Company::getStatus, 1).orderByAsc(Company::getName).list();
        List<CompanyVO> companyVOS = list.stream().map(item -> BeanUtil.copyProperties(item, CompanyVO.class)).collect(Collectors.toList());
        return companyVOS;
    }

    @Override
    public IPage<CompanyVO> page(CompanyPageDTO companyPageDTO) {
        Page<Company> page = this.lambdaQuery()
                .like(StringUtils.isNotBlank(companyPageDTO.getName()), Company::getName, companyPageDTO.getName())
                .eq(Objects.nonNull(companyPageDTO.getStatus()), Company::getStatus, companyPageDTO.getStatus())
                .page(new Page<>(companyPageDTO.getPageNo(), companyPageDTO.getPageSize()));
        return page.convert(item -> BeanUtil.copyProperties(item, CompanyVO.class));
    }
}
