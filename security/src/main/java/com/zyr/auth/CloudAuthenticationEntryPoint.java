package com.zyr.auth;


import com.zyr.common.util.CloudResponseUtils;
import com.zyr.common.vo.CloudResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 未登录拦截
 */
@Slf4j
@Component
public class CloudAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException  authenticationException) {
        if (authenticationException!=null){
            CloudResponseUtils.out(response, CloudResult.createByErrorCodeMessage(401,authenticationException.getMessage()));
        } else {
            CloudResponseUtils.out(response, CloudResult.createByErrorCodeMessage(-1,"token无效或者格式不对"));


        }
    }

}
