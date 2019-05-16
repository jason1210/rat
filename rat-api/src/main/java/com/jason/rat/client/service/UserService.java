package com.jason.rat.client.service;

import com.jason.rat.client.model.User;

/**
 * @author: jason
 * @Date: 2019-05-16
 */
public interface UserService {

    int add(User user);

    int update(User user);

    int delete(Long id);

    User findById(Long id);
}
