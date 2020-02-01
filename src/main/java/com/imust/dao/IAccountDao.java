package com.imust.dao;

import com.imust.domain.Account;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/2/1 18:59
 * Content:
 */
public interface IAccountDao {

    List<Account> findAll();
}
