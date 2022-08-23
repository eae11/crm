package com.zyr.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyr.common.entity.CloudMenu;

public interface CloudMenuMapper extends BaseMapper<CloudMenu> {
    int deleteByPrimaryKey(String id);

    int insert(CloudMenu row);

    int insertSelective(CloudMenu row);

    CloudMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CloudMenu row);

    int updateByPrimaryKey(CloudMenu row);
}