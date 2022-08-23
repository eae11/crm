package com.zyr.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyr.common.entity.CloudRole;

public interface CloudRoleMapper extends BaseMapper<CloudRole> {
    int deleteByPrimaryKey(String id);

    int insert(CloudRole row);

    int insertSelective(CloudRole row);

    CloudRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CloudRole row);

    int updateByPrimaryKey(CloudRole row);
}