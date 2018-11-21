package priv.zsk.springbootdemo.entity;

import lombok.Data;

import java.util.List;

/**
 * 类描述：用户和角色对应表实体类
 *
 * @author zsk
 * @create 2017-10-30 16:58
 **/
@Data
public class UserAndRole {
    private Integer id;
    private Integer userId;
    private Integer roleId;
    private Integer avaliable;

    /*用于用户添加多个角色时接受角色id*/
    private List roleIdList;

}
