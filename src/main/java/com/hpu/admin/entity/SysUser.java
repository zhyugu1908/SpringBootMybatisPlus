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
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     *
     */
    @TableId(value = "id")
    private String id;

    /**
     * 登录名
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    private String icon;

    /**
     * 密码
     */
    private String password;

    /**
     * shiro加密盐
     */
    private String salt;

    /**
     * 手机号码
     */
    private String tel;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 是否锁定
     */
    private Integer locked;

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

    @TableField("is_admin")
    private Integer isAdmin;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
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

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public static final String ID = "id";

    public static final String LOGIN_NAME = "login_name";

    public static final String NICK_NAME = "nick_name";

    public static final String ICON = "icon";

    public static final String PASSWORD = "password";

    public static final String SALT = "salt";

    public static final String TEL = "tel";

    public static final String EMAIL = "email";

    public static final String LOCKED = "locked";

    public static final String CREATE_DATE = "create_date";

    public static final String CREATE_BY = "create_by";

    public static final String UPDATE_DATE = "update_date";

    public static final String UPDATE_BY = "update_by";

    public static final String REMARKS = "remarks";

    public static final String DEL_FLAG = "del_flag";

    public static final String IS_ADMIN = "is_admin";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        ", id=" + id +
        ", loginName=" + loginName +
        ", nickName=" + nickName +
        ", icon=" + icon +
        ", password=" + password +
        ", salt=" + salt +
        ", tel=" + tel +
        ", email=" + email +
        ", locked=" + locked +
        ", createDate=" + createDate +
        ", createBy=" + createBy +
        ", updateDate=" + updateDate +
        ", updateBy=" + updateBy +
        ", remarks=" + remarks +
        ", delFlag=" + delFlag +
        ", isAdmin=" + isAdmin +
        "}";
    }
}
