package com.jason.rat.server.service;

import com.jason.rat.client.model.User;
import com.jason.rat.client.service.UserService;
import com.jason.rat.server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author: jason
 * @Date: 2019-05-17
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
    @Override
    public User findByName(String userName) {
        return userMapper.selectByUserName(userName);
    }
}
