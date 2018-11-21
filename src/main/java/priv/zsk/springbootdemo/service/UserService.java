package priv.zsk.springbootdemo.service;



import priv.zsk.springbootdemo.entity.User;

import java.util.List;

public interface UserService {
    /*获取所有的用户信息*/
    List findUserList(User user);

    /*通过用户账号查询用户信息*/
    User findUserByAccount(String account);

    /*通过用户账号查询用户id*/
    Integer findUserIdByAccount(String account);

    /*添加用户*/
    void addUser(User user);

    /*更新用户*/
    void updateUser(User user);

    /*删除用户（逻辑删除）*/
    void deleteUser(User user);
}
