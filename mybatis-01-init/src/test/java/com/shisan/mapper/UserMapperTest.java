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

    @Test
    public void add() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 新增用户
        User user = new User(null, "王五", "wang123");

        Integer add = mapper.add(user);
        if (add > 0) {
            System.out.println("添加成功！");
        }
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 根据id删除用户
        Integer deleteById = mapper.deleteById(6);
        if (deleteById > 0) {
            System.out.println("操作成功！");
        }
        sqlSession.close();
    }

    @Test
    public void update() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 修改用户
        User user = new User(3, "xl", "240330");
        Integer update = mapper.update(user);
        if (update > 0) {
            System.out.println("操作成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 根据id查询 id = 1
        User user = mapper.findById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void findLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 根据name 模糊匹配
        List<User> users = mapper.findLike("shisan");
        for (User user : users) {
            System.out.println(user);

        }

        sqlSession.close();
    }
}
