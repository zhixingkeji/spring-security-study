package com.example.security.config;

import com.example.security.handle.MyAuthenticationFailureHandler;
import com.example.security.handle.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebConfig extends WebSecurityConfigurerAdapter {

//  注入密码加密器
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    自定义login页面
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login.html")
//                只能是post请求 只能跳转Controller
//                .successForwardUrl("/toMain")

//                前后端分离项目跳转
                .successHandler(new MyAuthenticationSuccessHandler("http://www.baidu.com"))

//                失败跳转
                .failureHandler(new MyAuthenticationFailureHandler("/error.html"));


        http.authorizeRequests()
                //登录,注册,错误页面不需要权限
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()

//                权限匹配,拥有以下任意一种权限即可访问
                .antMatchers("/vip.html").hasAnyAuthority("admin","admin2")

//               角色匹配 , 声明的时候要加ROLE_, 匹配时候不能加
                .antMatchers("/vip.html").hasAnyRole("abc,123")

//                IP地址匹配
                .antMatchers("/vip.html").hasIpAddress("127.0.0.1")


//                放行静态资源
                .antMatchers("/js/**","/css/**","/images/**").permitAll()

//                其他所有请求都要认证
                .anyRequest().authenticated();

//        关闭跨域防护
        http.csrf().disable();


//        自定义异常处理 403 权限不足
//        http.exceptionHandling()
//                .accessDeniedHandler(myAccessDeniedHandler);


//        退出功能 实现退出后跳转到登录页面
        http.logout()
                .logoutSuccessUrl("/login.html");




    }



}
