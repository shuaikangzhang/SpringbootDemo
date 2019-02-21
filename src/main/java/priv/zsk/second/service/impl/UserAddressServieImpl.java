package priv.zsk.second.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.zsk.datasources.DataSourceNames;
import priv.zsk.datasources.annotation.DataSource;
import priv.zsk.second.entity.UserAddressEntity;
import priv.zsk.second.mapper.UserAddressMapper;
import priv.zsk.second.service.UserAddressService;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018-11-28 14:21
 */
@Service
public class UserAddressServieImpl extends ServiceImpl<UserAddressMapper,UserAddressEntity> implements UserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Autowired
    private UserAddressService userAddressService;

    @DataSource(name = DataSourceNames.secondData)
    @Override
    public List<UserAddressEntity> findUserAddressList(Integer userId) {
//        return userAddressService.list(new QueryWrapper<UserAddressEntity>().eq("user_id",userId));
        return userAddressMapper.selectList(new QueryWrapper<UserAddressEntity>().eq("user_id",userId));
//        return userAddressMapper.findUserAddressList(userId);
    }
}
