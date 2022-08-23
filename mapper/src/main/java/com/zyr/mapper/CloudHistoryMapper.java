package com.zyr.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyr.common.entity.CloudHistory;

public interface CloudHistoryMapper extends BaseMapper<CloudHistory> {
    int deleteByPrimaryKey(String id);

    int insert(CloudHistory row);

    int insertSelective(CloudHistory row);

    CloudHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CloudHistory row);

    int updateByPrimaryKey(CloudHistory row);
}