package com.zyr.common.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * (CrmWork)表实体类
 *
 * @author Array老师
 * @since 2020-08-09 18:10:27
 */
@SuppressWarnings("serial")
public class CrmWork extends Model<CrmWork> {
    //工作台ID
    private String workId;
    //工作台名称
    private String workName;
    //工作台类型
    private String workType;
    //工作台详细介绍
    private String workTitile;
    //是否展示
    private String workShow;
    //工作台计数
    private String workCount;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;
    //上一层级ID
    private String pid;


    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkTitile() {
        return workTitile;
    }

    public void setWorkTitile(String workTitile) {
        this.workTitile = workTitile;
    }

    public String getWorkShow() {
        return workShow;
    }

    public void setWorkShow(String workShow) {
        this.workShow = workShow;
    }

    public String getWorkCount() {
        return workCount;
    }

    public void setWorkCount(String workCount) {
        this.workCount = workCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

}