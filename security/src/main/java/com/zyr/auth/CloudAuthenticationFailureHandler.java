package com.zyr.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyr.common.vo.CloudResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证逻辑处理
 */
@Slf4j
@Component
public class CloudAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, ServletException {
        CloudResult<Object> message = null;
        if (authenticationException instanceof UsernameNotFoundException || authenticationException instanceof BadCredentialsException) {
            message = CloudResult.createByErrorMessage(authenticationException.getMessage());

        } else if (authenticationException instanceof CredentialsExpiredException) {
            message = CloudResult.createByErrorMessage("CredentialsExpiredException，cert证书验证异常！");

        } else if (authenticationException instanceof AccountExpiredException) {
            message = CloudResult.createByErrorMessage("AccountExpiredException，账号授权已经失效！");

        } else if (authenticationException instanceof LockedException || authenticationException instanceof DisabledException) {
            message = CloudResult.createByErrorMessage("LockedException，账号已经Lock！");

        } else {
            message = CloudResult.createByErrorMessage("IOException，登录异常，系统错误！");
        }

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(message));

    }

}
