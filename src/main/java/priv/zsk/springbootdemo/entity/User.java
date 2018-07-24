package priv.zsk.springbootdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author:zsk
 * @CreateTime:2018/6/27 14:55
 *
 * 用于测试apimodel的使用
 */
@ApiModel
@Data
public class User implements Serializable {
    private int id;

    @ApiModelProperty(value="用户名",name="accountTest",example="123",required = true)
    private String account;

    private String password;
    private String userName;
}
