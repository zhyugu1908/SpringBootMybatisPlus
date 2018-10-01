package com.hpu.commomn.base;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * Created by zhangyuguang on 2018/9/30.
 */
public class BaseEntity <T extends Model> extends Model<T> {

    @TableField
    protected String id;

    public BaseEntity(){

    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public BaseEntity(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public boolean equals(Object obj){
        if (obj==null){
            return false;
        }
        if (this==obj){
            return true;
        }
        if (!getClass().equals(obj.getClass())){
            return false;
        }
        BaseEntity<?> that = (BaseEntity<?>)obj;
        return null != this.getId() && this.getId().equals(that.getId());
    }
}
