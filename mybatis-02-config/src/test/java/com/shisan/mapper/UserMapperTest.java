package com.shisan.mapper;


import com.shisan.pojo.User;
import com.shisan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author:shisan
 * @Date:2023/10/30 10:22
 */
public class UserMapperTest {
    @Test
    // 方式一：
    public void findAll() {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        // 查询全部
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        // 关闭SQLSession
        sqlSession.close();
    }


}
