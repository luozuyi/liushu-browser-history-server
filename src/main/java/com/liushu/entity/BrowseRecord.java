package com.liushu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mayn
 */
public class BrowseRecord implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 删除状态
     */
    private String delFlag;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 流书id
     */
    private String bookFlowId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBookFlowId() {
        return bookFlowId;
    }

    public void setBookFlowId(String bookFlowId) {
        this.bookFlowId = bookFlowId == null ? null : bookFlowId.trim();
    }
}