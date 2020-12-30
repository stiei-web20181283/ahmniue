package com.ahmniue.manage.service.impl;

import com.ahmniue.generator.mapper.UserMapper;
import com.ahmniue.generator.model.User;
import com.ahmniue.generator.model.UserExample;
import com.ahmniue.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户管理service实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listAllUser() {
        return userMapper.selectByExample(new UserExample());
    }
}
