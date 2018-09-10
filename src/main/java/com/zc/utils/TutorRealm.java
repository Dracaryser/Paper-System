package com.zc.utils;

import com.zc.service.StudentService;
import com.zc.service.TutorService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class TutorRealm extends AuthorizingRealm {
    @Autowired
    TutorService tutorService;

    {
        super.setName("TutorRealm");
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String id = (String) authenticationToken.getPrincipal();
        String password = getPasswordById(id);
        if(password == null) return null;

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(id,password,"TutorRealm");
        return simpleAuthenticationInfo;
    }

    private String getPasswordById(String id) {
        return tutorService.getPasswordById(id);
    }
}
