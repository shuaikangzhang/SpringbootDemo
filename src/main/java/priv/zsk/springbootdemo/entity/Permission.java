package priv.zsk.springbootdemo.entity;

import lombok.Data;

/**
 * 类描述：资源权限实体类
 *
 * @author zsk
 * @create 2017-10-30 16:55
 **/
@Data
public class Permission {
    private Integer id;
    private String permissionName;
    private String resourceName;
    private String resourceType;
    private String url;
    private String resourceCode;
    private Integer parentid;
    private String parentids;
    private String sortstring;
    private Integer avaliable;
    private String createTime;
    private Integer deleted;

    private String avaliableStr;

}
