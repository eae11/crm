package com.zyr.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统管理
 */
@Data
@ApiModel(description = "系统管理 - 角色-菜单关联表 查询参数")
public class RoleMenuVo {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
    @ApiModelProperty(value = "菜单ids")
    private String menuIds;
}
