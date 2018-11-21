package priv.zsk.springbootdemo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.zsk.springbootdemo.entity.User;
import priv.zsk.springbootdemo.mapper.UserMapper;
import priv.zsk.springbootdemo.service.UserService;

import java.util.List;

/**
 * 类描述：
 *
 * @author zsk
 * @create 2017-10-27 15:21
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List findUserList(User user) {
        return userMapper.findUserList(user);
    }

    @Override
    public User findUserByAccount(String account) {
        return userMapper.findUserByAccount(account);
    }

    @Override
    public Integer findUserIdByAccount(String account) {
        return userMapper.findUserIdByAccount(account);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }
}
