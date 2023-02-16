package com.cyriii.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyriii.dto.UserPageDTO;
import com.cyriii.dto.UserUpdateDTO;
import com.cyriii.model.User;
import com.cyriii.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User> {
    UserVO getById(Long id);

    void updateUser(UserUpdateDTO userUpdateDTO);

    IPage<UserVO> page(UserPageDTO userPageDTO);
}
