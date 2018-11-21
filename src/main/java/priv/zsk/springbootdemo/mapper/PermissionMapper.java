package priv.zsk.springbootdemo.mapper;



import org.apache.ibatis.annotations.Mapper;
import priv.zsk.springbootdemo.entity.Permission;

import java.util.List;

@Mapper
public interface PermissionMapper<T> {
    /*获取所有的资源和权限关系*/
    List<T> findPermissionList(Permission permission);


    /*通过权限的ID获取该权限的详细信息*/
    Permission findPermissionById(int id);

    /*增加权限*/
    void addPermission(Permission permisison);

    /*更新权限包括更新权限操作，逻辑删除和禁用权限*/
    void updatePermission(Permission permission);

    /*禁用权限*/
    void disablePermission(Permission permission);

    /*删除权限*/
    void deletePermission(Permission permission);


}
