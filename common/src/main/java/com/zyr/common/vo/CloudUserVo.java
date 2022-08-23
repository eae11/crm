package com.zyr.common.vo;

import com.zyr.common.entity.CloudRole;
import com.zyr.common.entity.CloudUser;
import lombok.Data;

@Data
public class CloudUserVo extends CloudUser {


    private CloudRole cloudRole;
    private  String roleId;
    private  String roleName;
}
