package com.jason.rat.portal.controller;

import com.alibaba.fastjson.JSONObject;
import com.jason.rat.biz.common.util.UserUtil;
import com.jason.rat.client.result.Result;
import com.jason.rat.client.vo.UserVO;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.jason.rat.biz.common.util.UserUtil.getUserInfo;

/**
 * @author: jason
 * @Date: 2019-05-15
 */
@CrossOrigin
@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @ResponseBody
    @PostMapping("/login")
    public Result login(@RequestBody JSONObject jsonParam, HttpServletRequest request) {
        System.out.println(jsonParam.toJSONString());

        //验证验证码
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        String vcode = (String)request.getSession().getAttribute("vcode");
        if (!jsonParam.getString("code").equalsIgnoreCase(vcode)) {
            return Result.validateError("验证码错误！");
        }
        //添加用户认证信息
        try {
            UserUtil.authenticateUser(jsonParam.getString("username"), jsonParam.getString("password"));
        } catch (AuthenticationException e) {
            return Result.validateError("用户名或密码错误！");
        }
        UserVO userVO = new UserVO();
        userVO.setUserId(getUserInfo().getId());
        userVO.setUsername(getUserInfo().getUsername());
        return Result.success(userVO);
    }
}
