package com.huge.mapper;

import com.huge.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Description:变量描述
 * Author:胡正林823865618@qq.com)
 * Date:2019/6/22-18:07
 */
public interface UserMapper {
    /**
     * 查询所有用户
     * */
    @Select("select * from tb_user")
    List<User> listUser();

    /**
     * 添加用户
     * */
    @Insert("insert tb_user values(null,#{uname},#{upassword},#{sex},#{birthdate},#{address})")
    void addUser(User user);

    /**
     * 修改用户
     * */
    @Update("update tb_user set uname=#{uname},upassword=#{upassword},sex=#{sex},birthdate=#{birthdate},address=#{address} where uid=#{uid}")
    void updateUser(User user);
    /**
     * 删除用户
     * */
    @Delete("delete from tb_user where uid=#{uid}")
    void delete(int uid);
}
