package com.zyr.common.vo;

import com.zyr.common.entity.CloudRoleMenu;
import lombok.Data;

import java.util.List;

@Data
public class CloudRoleMenusVo extends CloudRoleMenu {
    private List<CloudMenuVo> yunMenus;

    private  List<String> children;
}
