package com.zyr.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统-角色表 (CloudRole)表实体类
 *
 * @author Array老师
 * @since 2020-03-21 14:56:25
 */
@SuppressWarnings("serial")

public class CloudRole extends Model<CloudRole> {
    //主键ID
    @TableId(value = "id")
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    //角色英文
    private String roleEn;
    //角色中文
    private String roleCn;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //描述
    private String describeText;
    //是否启用
    private String isEnable;
    //系统用户
    private String readonly;
    //创建者
    private String createUser;
    //更新者
    private String updateUser;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleEn() {
        return roleEn;
    }

    public void setRoleEn(String roleEn) {
        this.roleEn = roleEn;
    }

    public String getRoleCn() {
        return roleCn;
    }

    public void setRoleCn(String roleCn) {
        this.roleCn = roleCn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescribeText() {
        return describeText;
    }

    public void setDescribeText(String describeText) {
        this.describeText = describeText;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getReadonly() {
        return readonly;
    }

    public void setReadonly(String readonly) {
        this.readonly = readonly;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }