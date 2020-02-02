package com.imust;


import com.imust.dao.IAccountDao;
import com.imust.dao.IUserDao;
import com.imust.domain.Account;
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
public class AccountTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

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
        accountDao = sqlSession.getMapper(IAccountDao.class);
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
   public void TestfindAll(){
        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }


}
