package com.imust.dao;

import com.imust.domain.QueryVo;
import com.imust.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/1/31 19:54
 * Content:
 */

//注解的方式开启二级缓存
//@CacheNamespace(blocking = true)
public interface IUserDao {


//    注解的方式修改名字，解决和数据库表不对应的问题
//    @Results(id = "userMap", value = {
//        @Result(id = true,column = "id",property = "userId"),
//        @Result(column = "username",property = "username"),
//    })
//    @Select("select * from user")
    List<User> findAll();

//    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
//    @ResultMap("userMap")
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int uid);

    User findUser(Integer id);

    List<User> findUserByName(String name);

    int UserTotal();

    List<User> findAllUserByName(QueryVo queryVo);

    List<User> findUserByCondition(User user);

    List<User> findUserByIds(QueryVo queryVo);
}
