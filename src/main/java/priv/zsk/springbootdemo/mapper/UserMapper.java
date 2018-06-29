package priv.zsk.springbootdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import priv.zsk.springbootdemo.entity.User;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018/6/27 14:58
 */
@Mapper
public interface UserMapper<T> {
    //查询用户列表信息
    List<T> findUserList();

    //修改用户信息
    void updateUser(User user);
}
