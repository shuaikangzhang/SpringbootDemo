package priv.zsk.springbootdemo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.zsk.springbootdemo.entity.Role;
import priv.zsk.springbootdemo.entity.RoleAndPermission;
import priv.zsk.springbootdemo.mapper.RoleAndPermissionMapper;
import priv.zsk.springbootdemo.service.RoleAndPermissionService;

import java.util.List;

/**
 * 类描述：绝世和权限实现类
 *
 * @author zsk
 * @create 2017-10-30 17:29
 **/
@Service
public class RoleAndPermissionServiceImpl<T> implements RoleAndPermissionService {
    @Autowired
    private RoleAndPermissionMapper roleAndPermissionMapper;

    @Override
    public List findRoleAndPermissionList(Role role) {
        return roleAndPermissionMapper.findRoleAndPermissionList(role);
    }

    @Override
    public List findPermissionIdByRoleIdList(RoleAndPermission roleAndPermission) {
        return roleAndPermissionMapper.findPermissionIdByRoleIdList(roleAndPermission);
    }

    @Override
    public List<T> findPermissionIdByRoleId(int roleId) {
        return roleAndPermissionMapper.findPermissionIdByRoleId(roleId);
    }

    @Override
    public void addRoleAndPermission(RoleAndPermission roleAndPermission) {
        roleAndPermissionMapper.addRoleAndPermission(roleAndPermission);
    }

    @Override
    public void deleteRoleAndPermission(RoleAndPermission roleAndPermission) {
        roleAndPermissionMapper.deleteRoleAndPermission(roleAndPermission);
    }

    @Override
    public void updateRoleAndPermissionAvaliable(RoleAndPermission roleAndPermission) {
        roleAndPermissionMapper.updateRoleAndPermissionAvaliable(roleAndPermission);
    }
}
