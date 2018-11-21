package priv.zsk.springbootdemo.service;


import priv.zsk.springbootdemo.entity.SecurityResource;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018/5/2 19:01
 */
public interface SecurityResourceService<T> {
    /*获取所有已经配置好的url和权限信息*/
    List<T> findSecurityResourceList(SecurityResource securityResource);
}
