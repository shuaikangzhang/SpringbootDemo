package priv.zsk.second.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.zsk.second.entity.UserAddressEntity;
import priv.zsk.second.mapper.UserAddressMapper;
import priv.zsk.second.service.UserAddressService;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018-11-28 14:21
 */
@Service
public class UserAddressServieImpl implements UserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddressEntity> findUserAddressList(Integer userId) {
        return userAddressMapper.findUserAddressList(userId);
    }
}
