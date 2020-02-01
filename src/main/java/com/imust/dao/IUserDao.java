package com.imust.dao;

import com.imust.domain.QueryVo;
import com.imust.domain.User;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/1/31 19:54
 * Content:
 */
public interface IUserDao {

    List<User> findAll();

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
