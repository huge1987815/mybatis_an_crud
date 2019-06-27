package com.huge.test;

import com.huge.entity.User;
import com.huge.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

/**
 * Description:变量描述
 * Author:胡正林823865618@qq.com)
 * Date:2019/6/23-19:03
 */
public class MyTest {
    @Test
    public void deleteUser() throws IOException {
//写一个字符串
        String resource="mybatis.xml";
        //写一个输入流
        InputStream stream = Resources.getResourceAsStream(resource);
        //获取session对象
        SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession();
        //获取mapper
        UserMapper mapper = session.getMapper(UserMapper.class);
        //删除数据
      mapper.delete(1);
        //提交数据
        session.commit();
        //释放资源
        session.close();
    }
    @Test
    public void updateUser() throws IOException {
        //写一个字符串
        String resource="mybatis.xml";
        //写一个输入流
        InputStream stream = Resources.getResourceAsStream(resource);
        //获取session对象
        SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession();
        //获取mapper
        UserMapper mapper = session.getMapper(UserMapper.class);
        //修改数据
        User u=new User(5,"田七","456","女",Date.valueOf("1990-09-10"),"北京霍营");
        mapper.updateUser(u);
        //提交数据
        session.commit();
        //释放资源
        session.close();
    }
    @Test
    public void addUser() throws IOException {
        //写一个字符串
        String resource="mybatis.xml";
        //写一个输入流
        InputStream stream = Resources.getResourceAsStream(resource);
        //获取session对象
        SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession();
        //获取mapper对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        //写一个User对象
        User user=new User("赵六","123","男", Date.valueOf("1995-09-09"),"上海奉贤");
        mapper.addUser(user);
        session.commit();
        //释放资源
        session.close();
    }
    @Test
    public void listUser() throws IOException {
        //写一个字符串
        String resource="mybatis.xml";
        //写一个输入流
        InputStream stream = Resources.getResourceAsStream(resource);
        //获取SqlSessionFactory对象
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(stream);
        //获取session
        SqlSession session = sf.openSession();
        //调用方法
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = mapper.listUser();
        for (User user:list) {
            System.out.println(user);
        }
    }
}
