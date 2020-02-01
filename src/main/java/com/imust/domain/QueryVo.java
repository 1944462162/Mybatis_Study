package com.imust.domain;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/2/1 11:36
 * Content:
 */
public class QueryVo {

    private User user;

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
