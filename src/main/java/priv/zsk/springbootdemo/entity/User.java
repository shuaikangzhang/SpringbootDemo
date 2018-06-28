package priv.zsk.springbootdemo.entity;

import lombok.Data;

/**
 * @author:zsk
 * @CreateTime:2018/6/27 14:55
 */
@Data
public class User {
    private int id;
    private String account;
    private String password;
    private String userName;
}
