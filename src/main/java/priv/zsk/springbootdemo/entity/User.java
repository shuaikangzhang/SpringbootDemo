package priv.zsk.springbootdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018/6/27 14:55
 *
 * 用于测试apimodel的使用
 */
@ApiModel
@Data
public class User<T> implements Serializable {
    private int id;

    @ApiModelProperty(value="用户名",name="accountTest",example="123",required = true)
    private String account;

    private String userPassword;
    private String userName;
    private String sex;
    private String mobile;
    private Integer age;
    private String address;
    private String remark;
    private String createTime;
    private String salt;
    private Integer deleted;

    private String userPasswordCheck;
    private List<T> roleList;
    private List<T> disRoleList;
    private String roleStr;
    private String disRoleStr;
    private List roleIdList;


}
