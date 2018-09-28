package com.hpu.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhang Yu Guang
 * @since 2018-09-27
 */
@TableName("sys_role")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;
    // 主键映射很关键
    @TableId(value = "id")
    private String id;

    /**
     * 角色名称
     */
    private String name;

    @TableField("create_date")
    private LocalDateTime createDate;

    @TableField("create_by")
    private String createBy;

    @TableField("update_date")
    private LocalDateTime updateDate;

    @TableField("update_by")
    private String updateBy;

    private String remarks;

    @TableField("del_flag")
    private Integer delFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String CREATE_DATE = "create_date";

    public static final String CREATE_BY = "create_by";

    public static final String UPDATE_DATE = "update_date";

    public static final String UPDATE_BY = "update_by";

    public static final String REMARKS = "remarks";

    public static final String DEL_FLAG = "del_flag";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysRole{" +
        ", id=" + id +
        ", name=" + name +
        ", createDate=" + createDate +
        ", createBy=" + createBy +
        ", updateDate=" + updateDate +
        ", updateBy=" + updateBy +
        ", remarks=" + remarks +
        ", delFlag=" + delFlag +
        "}";
    }
}
