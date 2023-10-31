package com.shisan.mapper;

import com.shisan.pojo.User;

import java.util.List;

/**
 * @Author:shisan
 * @Date:2023/10/30 8:01
 */
public interface UserMapper {

    List<User> findAll();

    User findById(Integer id);

    Integer add(User user);

    Integer update(User user);

    Integer deleteById(Integer id);

}
