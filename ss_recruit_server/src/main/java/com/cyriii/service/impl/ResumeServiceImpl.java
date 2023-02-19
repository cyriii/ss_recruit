package com.cyriii.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyriii.dto.ResumeSaveDTO;
import com.cyriii.mapper.ResumeMapper;
import com.cyriii.model.Resume;
import com.cyriii.service.ResumeService;
import com.cyriii.vo.ResumeVO;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume> implements ResumeService {

    @Override
    public ResumeVO getByUserId(Long userId) {
        Resume resume = this.lambdaQuery().eq(Resume::getUserId, userId).one();
        return BeanUtil.copyProperties(resume, ResumeVO.class);
    }

    @Override
    public void save(ResumeSaveDTO resumeSaveDTO) {
        Long userId = StpUtil.getLoginIdAsLong();
        ResumeVO resumeVO = this.getByUserId(userId);
        Resume resume = BeanUtil.copyProperties(resumeSaveDTO, Resume.class);
        if (Objects.isNull(resumeVO)) {
            resume.setId(null);
            resume.setUserId(userId);
            this.save(resume);
        } else {
            resume.setId(resumeVO.getId());
            this.updateById(resume);
        }
    }
}
