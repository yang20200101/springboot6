package com.example.demo.control;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:lkj
 * @Date:2021/1/9
 * @Description：com.example.demo.control
 * @version：1.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Obkect handle) throws  Exception{
        Object user=request.getSession().getAttribute("loginUser");
        if(user==null){
            request.setAttribute("msg","请重新登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
        }else{
            return  true;
        }
         return  false;
    }

    public void addHandleInterceptors(InterceptorRegistry registry){
        //addPathPatterns拦截地址
        //excludePathPatterns排查不需要拦截的地址
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/asserts/**","/webjars/**","/user/login");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer=new WebMvcConfigurer(){
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
        }
        return configurer;
    }
}
