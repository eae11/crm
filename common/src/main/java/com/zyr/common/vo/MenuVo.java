package com.zyr.common.vo;

import com.google.common.collect.Lists;
import com.zyr.common.entity.CloudMenu;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  菜单
 */
@Data
public class MenuVo extends CloudMenu implements Serializable {



    List<MenuVo> children = Lists.newArrayList();

}
