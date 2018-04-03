package com.guonl.proxy;

import java.util.List;

/**
 * Created by guonl
 * Date 2018/4/3 下午5:39
 * Description:
 */
public class UserManagerImpl implements UserManager{

    @Override
    public void addUser(String username, String password) {
        System.out.println("---UserManagerImpl:addUser---");

    }

    @Override
    public void delUser(int userId) {
        System.out.println("---UserManagerImpl:delUser---");

    }

    @Override
    public void modifyUser(int userId, String username, String password) {
        System.out.println("---UserManagerImpl:modifyUser---");

    }

    public void addBatch(List<String> users) {
        System.out.println("---UserManagerImpl:addBatch---");
    }
}
