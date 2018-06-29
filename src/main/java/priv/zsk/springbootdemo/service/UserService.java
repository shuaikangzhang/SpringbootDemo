package priv.zsk.springbootdemo.service;

import priv.zsk.springbootdemo.entity.User;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018/6/27 15:53
 */
public interface UserService<T> {

    //查询用户信息
    List<T> findUserList();

    //修改用户信息
    void updateUser(User user);
}
