package com.zyr.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyr.common.entity.CloudRoleMenu;

public interface CloudRoleMenuMapper extends BaseMapper<CloudRoleMenu> {
    int deleteByPrimaryKey(String id);

    int insert(CloudRoleMenu row);

    int insertSelective(CloudRoleMenu row);

    CloudRoleMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CloudRoleMenu row);

    int updateByPrimaryKey(CloudRoleMenu row);
}