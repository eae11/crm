package com.zyr.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyr.common.entity.CloudUserRole;

public interface CloudUserRoleMapper extends BaseMapper<CloudUserRole> {
    int deleteByPrimaryKey(String id);

    int insert(CloudUserRole row);

    int insertSelective(CloudUserRole row);

    CloudUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CloudUserRole row);

    int updateByPrimaryKey(CloudUserRole row);
}