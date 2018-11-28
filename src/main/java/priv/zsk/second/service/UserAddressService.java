package priv.zsk.second.service;

import priv.zsk.second.entity.UserAddressEntity;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018-11-28 14:19
 */
public interface UserAddressService {

    List<UserAddressEntity> findUserAddressList(Integer userId);
}
