package priv.zsk.springbootdemo.service;



import priv.zsk.springbootdemo.entity.User;
import priv.zsk.springbootdemo.entity.UserAndRole;

import java.util.List;

public interface UserAndRoleService<T> {
    /*查询用户角色对应信息*/
    List<T> findUserAndRoleList(User user);

//    List<T> findRoleIdByUserIdList(UserAndRole userAndRole);

    /*通过用户id查询用户角色id*/
    List<T> findRoleIdByUserId(int userId);

    /*为用户分配角色*/
    void addUserAndRole(UserAndRole userAndRole);

    /*通过用户id删除用户角色信息*/
    void deleteUserAndRole(UserAndRole userAndRole);

    /* 角色修改有效或者无效时设置用户角色表中*/
    void updateUserAndRoleAvaliable(UserAndRole userAndRole);
}
