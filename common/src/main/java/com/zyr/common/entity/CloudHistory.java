package com.zyr.common.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统 - 日志表(CloudHistory)表实体类
 *
 * @author Array老师
 * @since 2020-03-21 14:56:23
 */
@SuppressWarnings("serial")
/*
@SuppressWarnings注解的作用抑制编译器产生警告信息，其中serial关键字是忽略在serializable类中没有声明serialVersionUID变量的警告
 */
public class CloudHistory extends Model<CloudHistory> {
    //id
    private Long id;
    //业务名称
    private String serviceName;
    //业务地址
    private String serviceUrl;
    //IP
    private String requestIp;
    //用户id，0:未登录用户操作
    private String userId;
    //运行状态
    private Integer runStatus;
    //后台运行时间
    private String consumingTime;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //app,pc
    private String serviceType;
    //post,get
    private String httpMethod;
    //浏览器
    private String ua;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(Integer runStatus) {
        this.runStatus = runStatus;
    }

    public String getConsumingTime() {
        return consumingTime;
    }

    public void setConsumingTime(String consumingTime) {
        this.consumingTime = consumingTime;
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

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
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