package com.zyr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyr.common.entity.CloudUser;
import com.zyr.mapper.CloudUserMapper;
import com.zyr.service.CloudUserService;
import org.springframework.stereotype.Service;

@Service
public class CloudUserServiceImpl extends ServiceImpl<CloudUserMapper, CloudUser> implements CloudUserService {
}
