package com.example.demo.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:lkj
 * @Date:2021/1/7
 * @Description：com.example.demo
 * @version：1.0
 */
@RestController
public class FileControl {

    @RequestMapping(value = "hello2")
    public String getFile(){
        return "hello world";
    }

    @RequestMapping(value = "test")
    public String test(){
        return "test world";
    }



    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
        request.setAttribute("name", name);
        return "hello";
    }

}
