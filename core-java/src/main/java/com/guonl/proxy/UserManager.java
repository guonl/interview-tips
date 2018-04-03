package com.guonl.proxy;

/**
 * Created by guonl
 * Date 2018/4/3 下午5:25
 * Description:
 */
public interface UserManager {
    public void addUser(String username,String password);
    public void delUser(int userId);
    public void modifyUser(int userId,String username,String password);
}
