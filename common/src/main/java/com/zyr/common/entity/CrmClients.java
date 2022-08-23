package com.zyr.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 自定义字段表(CrmClients)实体类
 *
 * @author Array老师
 * @since 2020-08-08 16:14:15
 */
public class CrmClients implements Serializable {
    private static final long serialVersionUID = 717067547161226502L;
    /**
     * 主键ID
     */
    @TableId(value = "client_id")
    private String clientId;
    /**
     * 客户名称
     */
    private String clientName;
    /**
     * 客户类型
     */
    private Integer clientType;
    /**
     * 座机
     */
    private String clientTelephone;
    /**
     * 手机
     */
    private String clientMobile;
    /**
     * 官网
     */
    private String clientWebsite;
    /**
     * 默认值
     */
    private Date lastTime;
    /**
     * 联系人
     */
    private Integer contactsId;
    /**
     * 创建人ID
     */
    private Long createUserId;
    /**
     * 负责人ID
     */
    private Long ownerUserId;
    /**
     * 地址
     */
    private String clientAddress;
    /**
     * 定位信息
     */
    private String clientMap;
    /**
     * 详细地址
     */
    private String clientDetailAddress;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 客户状态
     */
    private Integer clientLastStatus;
    /**
     * 公海天数
     */
    private Integer openSeaDay;
    /**
     * 备注
     */
    private Integer remark;
    /**
     * 客户来源
     */
    private  Integer clientFrom;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public String getClientTelephone() {
        return clientTelephone;
    }

    public void setClientTelephone(String clientTelephone) {
        this.clientTelephone = clientTelephone;
    }

    public String getClientMobile() {
        return clientMobile;
    }

    public void setClientMobile(String clientMobile) {
        this.clientMobile = clientMobile;
    }

    public String getClientWebsite() {
        return clientWebsite;
    }

    public void setClientWebsite(String clientWebsite) {
        this.clientWebsite = clientWebsite;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getContactsId() {
        return contactsId;
    }

    public void setContactsId(Integer contactsId) {
        this.contactsId = contactsId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientMap() {
        return clientMap;
    }

    public void setClientMap(String clientMap) {
        this.clientMap = clientMap;
    }

    public String getClientDetailAddress() {
        return clientDetailAddress;
    }

    public void setClientDetailAddress(String clientDetailAddress) {
        this.clientDetailAddress = clientDetailAddress;
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

    public Integer getClientLastStatus() {
        return clientLastStatus;
    }

    public void setClientLastStatus(Integer clientLastStatus) {
        this.clientLastStatus = clientLastStatus;
    }

    public Integer getOpenSeaDay() {
        return openSeaDay;
    }

    public void setOpenSeaDay(Integer openSeaDay) {
        this.openSeaDay = openSeaDay;
    }

    public Integer getRemark() {
        return remark;
    }

    public void setRemark(Integer remark) {
        this.remark = remark;
    }

    public Integer getClientFrom() {
        return clientFrom;
    }

    public void setClientFrom(Integer clientFrom) {
        this.clientFrom = clientFrom;
    }
}