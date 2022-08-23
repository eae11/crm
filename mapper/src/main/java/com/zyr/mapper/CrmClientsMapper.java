package com.zyr.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyr.common.entity.CrmClients;

public interface CrmClientsMapper extends BaseMapper<CrmClients> {
    int deleteByPrimaryKey(String clientId);

    int insert(CrmClients row);

    int insertSelective(CrmClients row);

    CrmClients selectByPrimaryKey(String clientId);

    int updateByPrimaryKeySelective(CrmClients row);

    int updateByPrimaryKey(CrmClients row);
}