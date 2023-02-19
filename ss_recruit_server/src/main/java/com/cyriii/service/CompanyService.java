package com.cyriii.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyriii.dto.CompanyPageDTO;
import com.cyriii.model.Company;
import com.cyriii.vo.CompanyVO;

import java.util.List;

public interface CompanyService extends IService<Company> {
    List<CompanyVO> displayList();

    IPage<CompanyVO> page(CompanyPageDTO companyPageDTO);
}
