package com.zyr.auth;

import com.zyr.common.vo.CloudResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登出成功处理
 */
@Component
public class CloudAuthenticationLogoutHandler implements LogoutSuccessHandler {
    /**
     * 用户登出返回结果
     * 这里应该让前端清除掉Token
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
        Map<String,Object> result = new HashMap<>();
        result.put("code","200");
        result.put("msg", "登出成功");
        SecurityContextHolder.clearContext();
        CloudResult.createBySuccess(result);
    }
}