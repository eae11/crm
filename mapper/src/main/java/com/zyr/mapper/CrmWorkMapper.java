package com.zyr.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyr.common.entity.CrmWork;

public interface CrmWorkMapper extends BaseMapper<CrmWork> {
    int insert(CrmWork row);

    int insertSelective(CrmWork row);
}