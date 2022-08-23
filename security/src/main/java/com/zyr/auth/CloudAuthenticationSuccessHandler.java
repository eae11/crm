package com.zyr.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyr.common.entity.CloudUser;
import com.zyr.common.util.CloudResponseUtils;
import com.zyr.common.vo.CloudResult;
import com.zyr.common.vo.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 认证处理
 */
@Component
public class CloudAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication auth) throws IOException, ServletException {


        CloudUser user = new CloudUser();
        SecurityUser securityUser = ((SecurityUser) auth.getPrincipal());
        user.setLoginToken(securityUser.getLoginUser().getLoginToken());
        Map map = new HashMap();
        map.put("result", "success");
        map.put("loginToken", securityUser.getLoginUser().getLoginToken());
        CloudResponseUtils.out(response, CloudResult.createByCodeSuccess(200, "登录成功", map));
    }
}
