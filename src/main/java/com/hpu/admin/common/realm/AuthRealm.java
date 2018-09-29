package com.hpu.admin.common.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.io.Serializable;


/**
 * Created by zhangyuguang on 2018/9/29.
 */
public class AuthRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }


    /**
     * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
     */

    public static  class ShiroUser implements Serializable{

        public String id;
        public String loginName;
        public String nickName;
        public String icon;

        public ShiroUser(String id, String loginName, String nickName, String icon) {
            this.id = id;
            this.loginName = loginName;
            this.nickName = nickName;
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public String getLoginName() {
            return loginName;
        }

        public String getNickName() {
            return nickName;
        }

        public String getIcon() {
            return icon;
        }
    }
}
