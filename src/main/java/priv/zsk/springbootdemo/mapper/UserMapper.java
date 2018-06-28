package priv.zsk.springbootdemo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018/6/27 14:58
 */
@Mapper
public interface UserMapper<T> {
    List<T> findUserList();
}
