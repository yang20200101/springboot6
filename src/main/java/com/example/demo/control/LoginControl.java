package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author:lkj
 * @Date:2021/1/9
 * @Description：com.example.demo
 * @version：1.0
 */
@Controller
public class LoginControl {
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password, Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(userName) && "123456".equals(password)){
            session.setAttribute("loginUser",userName);
            return "success";
        }else {
            return "login";
        }
    }
}
