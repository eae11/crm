package com.zyr.common.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.google.common.collect.Sets;
import com.zyr.common.entity.CloudRole;
import com.zyr.common.entity.CloudUser;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class CloudUserInfoVo extends CloudUser implements Serializable {

    private Set<String> menuList;
    private Set<String> permissionList;
    @TableField(exist = false)
    private CloudRole role;

    private Set<String> roles = Sets.newHashSet();

    private Set<MenuVo> menus = Sets.newHashSet();



}
