package com.hpu.admin.common.cexception;


import org.apache.shiro.authc.DisabledAccountException;

/**
 * Created by zhangyuguang on 2018/9/29.
 */
public class UserTypeAccountException extends DisabledAccountException {

    public UserTypeAccountException(){
         super();
    }
}
