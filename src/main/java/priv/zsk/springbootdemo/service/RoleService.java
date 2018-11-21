package priv.zsk.springbootdemo.service;



import priv.zsk.springbootdemo.entity.Role;

import java.util.List;

public interface RoleService<T> {
    /*获取所有的角色信息*/
    List<T> findRoleList(Role role);

    /*通过角色id获取角色详细信息*/
    Role findRoleById(int id);
    /*插入新角色*/
    void addRole(Role role);

    /*更新角色*/
    void updateRole(Role role);

    /*删除角色*/
    void deleteRole(Role role);

    /*禁用角色*/
    void disableRole(Role role);
}
