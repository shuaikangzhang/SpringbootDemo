package priv.zsk.springbootdemo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.zsk.springbootdemo.entity.User;
import priv.zsk.springbootdemo.entity.UserAndRole;
import priv.zsk.springbootdemo.mapper.UserAndRoleMapper;
import priv.zsk.springbootdemo.service.UserAndRoleService;

import java.util.List;

/**
 * 类描述：用户和角色实现类
 *
 * @author zsk
 * @create 2017-10-30 17:28
 **/
@Service
public class UserAndRoleServiceImpl<T> implements UserAndRoleService {
    @Autowired
    private UserAndRoleMapper userAndRoleMapper;

    @Override
    public List findUserAndRoleList(User user) {
        return userAndRoleMapper.findUserAndRoleList(user);
    }

//    @Override
//    public List findRoleIdByUserIdList(UserAndRole userAndRole) {
//        return userAndRoleMapper.findRoleIdByUserIdList(userAndRole);
//    }

    @Override
    public List<T> findRoleIdByUserId(int userId) {
        return  userAndRoleMapper.findRoleIdByUserId(userId);
    }

    @Override
    public void addUserAndRole(UserAndRole userAndRole) {
        userAndRoleMapper.addUserAndRole(userAndRole);
    }

    @Override
    public void deleteUserAndRole(UserAndRole userAndRole) {
            userAndRoleMapper.deleteUserAndRole(userAndRole);
    }

    @Override
    public void updateUserAndRoleAvaliable(UserAndRole userAndRole) {
        userAndRoleMapper.updateUserAndRoleAvaliable(userAndRole);
    }
}
