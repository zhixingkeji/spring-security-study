package com.example.security.sys.controller;


import com.example.security.sys.model.User;
import com.example.security.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-11-10
 */
@Controller

public class UserController {
//    @Autowired
//    private UserService userService;
//
//    //    用户注册
//    @RequestMapping("/register")
//    public String register(User user){
//        try {
//            userService.register(user);
//            System.out.println("注册成功");
//            return "注册成功";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "注册失败";
//        }
//    }


    //    用户登录
//    @PostMapping("/toMain")
//    public String toMain(){
//        System.out.println("执行登录方法");
//        return "redirect:/a.html";
//    }

    //    用户登录

//    注解方式 角色判断, run方法开启注解
    @Secured("ROLE_abc")
    @PreAuthorize("hasRole('abc')")

    @PostMapping("/toError")
    public String toError(){
        System.out.println("执行登录方法");
        return "redirect:/error.html";
    }


}
