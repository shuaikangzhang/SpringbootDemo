package priv.zsk.springbootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.zsk.springbootdemo.mapper.UserMapper;
import priv.zsk.springbootdemo.service.UserService;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018/6/27 15:54
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List findUserList() {
        return userMapper.findUserList();
    }
}
