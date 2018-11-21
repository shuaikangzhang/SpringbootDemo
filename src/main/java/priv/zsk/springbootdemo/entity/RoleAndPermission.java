package priv.zsk.springbootdemo.entity;

import lombok.Data;

import java.util.List;

/**
 * 类描述：角色和权限对应表实体类
 *
 * @author zsk
 * @create 2017-10-30 16:53
 **/
@Data
public class RoleAndPermission{
    private Integer id;
    private Integer roleId;
    private Integer permissionId;
    private Integer avaliable;
    private String permissionStr;

    /*用于用户添加多个角色时接受角色id*/
    private List permissionIdList;

}
