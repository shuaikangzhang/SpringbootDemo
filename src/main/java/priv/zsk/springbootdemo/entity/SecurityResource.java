package priv.zsk.springbootdemo.entity;

import lombok.Data;

/**
 * @author:zsk
 * @CreateTime:2018/5/2 18:57
 */
@Data
public class SecurityResource {
    private Integer id;
    private String resourceUrl;
    private String permissionCode;
    private String remark;

}
