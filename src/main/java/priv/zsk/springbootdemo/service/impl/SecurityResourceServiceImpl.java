package priv.zsk.springbootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.zsk.springbootdemo.entity.SecurityResource;
import priv.zsk.springbootdemo.mapper.SecurityResourceMapper;
import priv.zsk.springbootdemo.service.SecurityResourceService;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2018/5/2 19:01
 */
@Service
public class SecurityResourceServiceImpl implements SecurityResourceService {
    @Autowired
    private SecurityResourceMapper securityResourceMapper;

    @Override
    public List findSecurityResourceList(SecurityResource securityResource) {
        return securityResourceMapper.findSecurityResourceList(securityResource);
    }
}
