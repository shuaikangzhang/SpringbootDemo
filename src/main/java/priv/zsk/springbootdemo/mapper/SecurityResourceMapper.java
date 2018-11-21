package priv.zsk.springbootdemo.mapper;


import org.apache.ibatis.annotations.Mapper;
import priv.zsk.springbootdemo.entity.SecurityResource;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018/5/2 18:58
 */

@Mapper
public interface SecurityResourceMapper<T> {
    /*获取所有已经配置好的url和权限信息*/
    List<T> findSecurityResourceList(SecurityResource securityResource);
}
