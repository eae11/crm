package com.zyr.auth;


import com.zyr.common.util.CloudResponseUtils;
import com.zyr.common.vo.CloudResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 自定义403无权限
 */
@Component
public class CloudUrlAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        CloudResponseUtils.out(response, CloudResult.createByCodeSuccess(403, e.getMessage(), ""));
    }
}
