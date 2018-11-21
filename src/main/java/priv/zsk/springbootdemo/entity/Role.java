package priv.zsk.springbootdemo.entity;

import lombok.Data;

import java.util.List;

/**
 * 类描述：角色实体类
 *
 * @author zsk
 * @create 2017-10-30 16:51
 **/
@Data
public class Role<T> {
    private Integer id;
    private String roleName;
    private String roleCode;
    private String createTime;
    private Integer avaliable;
    private Integer deleted;

    private String avaliableStr;
    private List<T> permissionList;
    private String permissionStr;
    private  List<T>disPermissionList;
    private String disPermissionStr;

}
