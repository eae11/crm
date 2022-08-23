package com.zyr.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyr.common.entity.CrmContacts;

public interface CrmContactsMapper extends BaseMapper<CrmContacts> {
    int deleteByPrimaryKey(String contactsId);

    int insert(CrmContacts row);

    int insertSelective(CrmContacts row);

    CrmContacts selectByPrimaryKey(String contactsId);

    int updateByPrimaryKeySelective(CrmContacts row);

    int updateByPrimaryKey(CrmContacts row);
}