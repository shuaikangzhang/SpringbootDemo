package priv.zsk.springbootdemo.service;



import priv.zsk.springbootdemo.entity.Role;
import priv.zsk.springbootdemo.entity.RoleAndPermission;

import java.util.List;

public interface RoleAndPermissionService<T> {
    /*查询角色资源信息*/
    List<T> findRoleAndPermissionList(Role role);

    /*通过角色id查询权限id*/
    List<T> findPermissionIdByRoleIdList(RoleAndPermission roleAndPermission);
    /*通过角色id查询权限id*/
    List<T> findPermissionIdByRoleId(int roleId);
    /*为角色分配权限*/
    void addRoleAndPermission(RoleAndPermission roleAndPermission);

    /*通过角色id删除该角色id下所有的权限信息*/
    void deleteRoleAndPermission(RoleAndPermission roleAndPermission);

    /*权限修改有效或者无效时设置角色权限表中信息*/
    void updateRoleAndPermissionAvaliable(RoleAndPermission roleAndPermission);
}
