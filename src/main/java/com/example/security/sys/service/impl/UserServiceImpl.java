package com.example.security.sys.service.impl;

import com.example.security.sys.model.User;
import com.example.security.sys.mapper.UserMapper;
import com.example.security.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-11-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findUser(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

    @Override
    public void register(User user) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User u = new User();
        u.setUsername("wl");
        u.setPassword(encoder.encode("123456"));
        u.setRole("admin");

        userMapper.save(u);
    }
}
