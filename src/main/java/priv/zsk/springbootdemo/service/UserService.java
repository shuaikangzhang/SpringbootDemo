package priv.zsk.springbootdemo.service;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018/6/27 15:53
 */
public interface UserService<T> {
    List<T> findUserList();
}
