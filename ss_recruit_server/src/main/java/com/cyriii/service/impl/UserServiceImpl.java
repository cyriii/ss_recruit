package com.cyriii.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyriii.dto.UserPageDTO;
import com.cyriii.dto.UserUpdateDTO;
import com.cyriii.mapper.UserMapper;
import com.cyriii.model.User;
import com.cyriii.service.UserService;
import com.cyriii.vo.UserVO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Cacheable(value = "ss:recruit:user", key = "#id")
    public UserVO getById(Long id) {
        User user = super.getById(id);
        return BeanUtil.copyProperties(user, UserVO.class);
    }

    @Override
    public void updateUser(UserUpdateDTO userUpdateDTO) {

    }


    @Override
    public IPage<UserVO> page(UserPageDTO userPageDTO) {
        Page<User> page = this.lambdaQuery()
                .orderByDesc(User::getCreateTime)
                .page(new Page<>(userPageDTO.getPageNo(), userPageDTO.getPageSize()));
        IPage<UserVO> convert = page.convert(item -> BeanUtil.copyProperties(item, UserVO.class));

        return convert;
    }
}
