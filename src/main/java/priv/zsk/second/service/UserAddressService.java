package priv.zsk.second.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.zsk.second.entity.UserAddressEntity;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018-11-28 14:19
 */
public interface UserAddressService extends IService<UserAddressEntity> {

    List<UserAddressEntity> findUserAddressList(Integer userId);
}
