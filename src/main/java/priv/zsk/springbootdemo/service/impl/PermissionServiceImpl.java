package priv.zsk.springbootdemo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.zsk.springbootdemo.entity.Permission;
import priv.zsk.springbootdemo.mapper.PermissionMapper;
import priv.zsk.springbootdemo.service.PermissionService;

import java.util.List;

/**
 * 类描述：资源权限实现类
 *
 * @author zsk
 * @create 2017-10-30 17:27
 **/
@Service
public class PermissionServiceImpl<T> implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<T> findPermissionList(Permission permission) {
        return permissionMapper.findPermissionList(permission);
    }

    @Override
    public Permission findPermissionById(int id) {
        return permissionMapper.findPermissionById(id);
    }

    @Override
    public void addPermission(Permission permisison) {
        permissionMapper.addPermission(permisison);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionMapper.updatePermission(permission);
    }

    @Override
    public void disablePermission(Permission permission) {
        permissionMapper.disablePermission(permission);
    }

    @Override
    public void deletePermission(Permission permission) {
        permissionMapper.deletePermission(permission);
    }

}
