package com.cyriii.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyriii.dto.UserPageDTO;
import com.cyriii.dto.UserUpdateDTO;
import com.cyriii.dto.UserUpdateStatusDTO;
import com.cyriii.mapper.UserMapper;
import com.cyriii.model.User;
import com.cyriii.service.UserService;
import com.cyriii.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Cacheable(value = "ss:recruit:user", key = "#id")
    public UserVO getById(Long id) {
        User user = super.getById(id);
        return BeanUtil.copyProperties(user, UserVO.class);
    }

    @Override
    @CacheEvict(value = "ss:recruit:user", key = "#id")
    public void updateUser(UserUpdateDTO userUpdateDTO) {

    }


    @Override
    public IPage<UserVO> page(UserPageDTO userPageDTO) {
        Page<User> page = this.lambdaQuery()
                .eq(StringUtils.isNotBlank(userPageDTO.getNickName()), User::getNickName, userPageDTO.getNickName())
                .eq(StringUtils.isNotBlank(userPageDTO.getMobile()), User::getMobile, userPageDTO.getMobile())
                .eq(Objects.nonNull(userPageDTO.getUserType()), User::getUserType, userPageDTO.getUserType())
                .eq(Objects.nonNull(userPageDTO.getSex()), User::getSex, userPageDTO.getSex())
                .eq(Objects.nonNull(userPageDTO.getStatus()), User::getStatus, userPageDTO.getStatus())
                .orderByDesc(User::getCreateTime)
                .page(new Page<>(userPageDTO.getPageNo(), userPageDTO.getPageSize()));
        return page.convert(item -> BeanUtil.copyProperties(item, UserVO.class));
    }

    @Override
    @CacheEvict(value = "ss:recruit:user", key = "#id")
    public void updateStatus(UserUpdateStatusDTO userUpdateStatusDTO) {
        User user = BeanUtil.copyProperties(userUpdateStatusDTO, User.class);
        this.updateById(user);
    }
}
