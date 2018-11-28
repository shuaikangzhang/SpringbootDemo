package priv.zsk.second.mapper;

import org.mapstruct.Mapper;
import priv.zsk.second.entity.UserAddressEntity;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018-11-28 14:17
 */
@Mapper
public interface UserAddressMapper {

    /*
    * 通过用户id查询用户住址
    * */
    List<UserAddressEntity> findUserAddressList(Integer userId);
}
