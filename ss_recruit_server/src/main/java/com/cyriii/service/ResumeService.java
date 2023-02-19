package com.cyriii.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyriii.dto.ResumeSaveDTO;
import com.cyriii.model.Resume;
import com.cyriii.vo.ResumeVO;

public interface ResumeService extends IService<Resume> {
    ResumeVO getByUserId(Long userId);

    void save(ResumeSaveDTO resumeSaveDTO);
}
