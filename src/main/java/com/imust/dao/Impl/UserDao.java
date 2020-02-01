package com.imust.dao.Impl;

import com.imust.dao.IUserDao;
import com.imust.domain.QueryVo;
import com.imust.domain.User;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/1/31 19:55
 * Content:
 */
public class UserDao implements IUserDao {

    /**
     * mybatis入门案例
     *      一、搭建maven工程
     *      二、创建实体类还有接口
     *      三、配置Mybatis主配置文件
     *              SqlMapConfig.xml
     *      四、创建映射文件
     * 注意事项：
     *      一、mybatis的映射文件位置必须和dao接口的包结构相同
     *      二、映射文件的mapper标签namespace属性的取值必须是dao接口的全限定类名
     *      三、映射文件的操作配置（select），id属性的取值必须是dao接口的方法名
     * @return
     */
    public List<User> findAll() {
        return null;
    }

    /**
     * 保存用户操作
     */
    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(int uid) {

    }

    public User findUser(Integer id) {
        return null;
    }

    public List<User> findUserByName(String name) {
        return null;
    }

    public int UserTotal() {
        return 0;
    }

    public List<User> findAllUserByName(QueryVo queryVo) {
        return null;
    }

    public List<User> findUserByCondition(User user) {
        return null;
    }

    public List<User> findUserByIds(QueryVo queryVo) {
        return null;
    }


}
