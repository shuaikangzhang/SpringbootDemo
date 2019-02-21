package priv.zsk.second.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import priv.zsk.second.entity.UserAddressEntity;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018-11-28 14:17
 */
@Mapper
public interface UserAddressMapper extends BaseMapper<UserAddressEntity> {

    /*
    * 通过用户id查询用户住址
    * */
    List<UserAddressEntity> findUserAddressList(Integer userId);
}
