package com.example.security.sys.mapper;

import com.example.security.sys.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2021-11-10
 */
public interface UserMapper extends BaseMapper<User> {
    User findByUsername(String username);
    void save(User user);
}
