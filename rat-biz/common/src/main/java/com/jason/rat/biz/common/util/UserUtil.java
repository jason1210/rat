package com.jason.rat.biz.common.util;

import com.jason.rat.client.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 * @author: jason
 * @Date: 2019-03-26
 */
public class UserUtil {

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    public static User getUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        return (User)subject.getPrincipal();
    }

    public static void authenticateUser(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        subject.login(usernamePasswordToken);
    }
}
