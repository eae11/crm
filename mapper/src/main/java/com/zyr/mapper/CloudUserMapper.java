package com.zyr.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyr.common.entity.CloudUser;

public interface CloudUserMapper extends BaseMapper<CloudUser> {
    int deleteByPrimaryKey(String id);

    int insert(CloudUser row);

    int insertSelective(CloudUser row);

    CloudUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CloudUser row);

    int updateByPrimaryKey(CloudUser row);
}