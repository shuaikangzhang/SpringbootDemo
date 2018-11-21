package priv.zsk.springbootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.zsk.springbootdemo.entity.Role;
import priv.zsk.springbootdemo.mapper.RoleMapper;
import priv.zsk.springbootdemo.service.RoleService;

import java.util.List;

/**
 * 类描述：角色实现类
 *
 * @author zsk
 * @create 2017-10-30 17:23
 **/
@Service
public class RoleServiceImpl<T> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List findRoleList(Role role) {
        return roleMapper.findRoleList(role);
    }

    @Override
    public Role findRoleById(int id) {
        return roleMapper.findRoleById(id);
    }

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleMapper.deleteRole(role);
    }

    @Override
    public void disableRole(Role role) {
        roleMapper.disableRole(role);
    }
}
