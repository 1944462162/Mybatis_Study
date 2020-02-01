package com.imust;


import com.imust.dao.IUserDao;
import com.imust.domain.QueryVo;
import com.imust.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/1/31 20:40
 * Content:
 */
public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factoryBuilder = sqlSessionFactoryBuilder.build(in);

        //使用工厂生产sqlSession对象
        sqlSession = factoryBuilder.openSession(true);

        //使用SQLSession创建Dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws IOException {
        //如果开启自动提交事务的话就不用再提交了
//        sqlSession.commit();
        //释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        //使用代理方式执行
        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void saveUser(){
        User user = new User();
        user.setUsername("哈哈");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("开鲁");
        System.out.println("保存之前-----"+user);
        userDao.saveUser(user);
        System.out.println("保存之后-----"+user);
        sqlSession.commit();
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(42);
        user.setUsername("哈哈");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("开鲁");
        userDao.updateUser(user);

    }

    @Test
    public void deleteUser(){
        userDao.deleteUser(42);
    }

    @Test
    public void getOneUser(){
        User user = userDao.findUser(43);
        System.out.println(user);
    }

    @Test
    public void findUserByName(){
        List<User> userByName = userDao.findUserByName("%王%");
        for (User user : userByName) {
            System.out.println(user);
        }
    }


    @Test
    public void UserTotal(){
        int i = userDao.UserTotal();
        System.out.println(i);
    }

    @Test
    public void findAllUserByName(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        List<User> allUserByName = userDao.findAllUserByName(queryVo);
        for (User user1 : allUserByName) {
            System.out.println(user1);
        }
    }

    @Test
    public void testFindByCondition(){
        User user = new User();
        user.setUsername("老王");

        List<User> users = userDao.findUserByCondition(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void testFindInIds(){
        QueryVo queryVo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(43);
        list.add(45);
        list.add(49);
        queryVo.setIds(list);
        List<User> userByIds = userDao.findUserByIds(queryVo);
        for (User userById : userByIds) {
            System.out.println(userById);
        }
    }
}
