package com.example.security.sys.service;

import com.example.security.sys.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-11-10
 */
public interface UserService extends IService<User> {
    User findUser(String username);
    void register(User user);
}
