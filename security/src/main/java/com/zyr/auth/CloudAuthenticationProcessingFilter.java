package com.zyr.auth;

import com.alibaba.fastjson.JSONObject;
import com.zyr.common.entity.CloudUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

import static com.zyr.set.Constants.REQUEST_METHOD_POST;


/**
 * 校验过滤器
 */
@Slf4j
@Component
public class CloudAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    public CloudAuthenticationProcessingFilter(CloudAuthenticationManager authenticationManager, CloudAuthenticationSuccessHandler cloudAuthenticationSuccessHandler, CloudAuthenticationFailureHandler cloudAuthenticationFailureHandler) {
        super(new AntPathRequestMatcher("/login", REQUEST_METHOD_POST));
        this.setAuthenticationManager(authenticationManager);
        this.setAuthenticationSuccessHandler(cloudAuthenticationSuccessHandler);
        this.setAuthenticationFailureHandler(cloudAuthenticationFailureHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (request.getContentType() == null || !request.getContentType().contains("application/json")) {
            throw new AuthenticationServiceException("security进行header的过滤和鉴权: " + request.getContentType());
        }
        UsernamePasswordAuthenticationToken authRequest;
        try {
            CloudUser user = JSONObject.parseObject(getJsonByData(request), CloudUser.class);
            authRequest = new UsernamePasswordAuthenticationToken(user.getAccountName(), user.getPassWord(), null);
            authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
        }
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * 格式化数据
     */
    public String getJsonByData(ServletRequest request) {

        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (Exception e) {
            log.error("Vue传递的格式不对！", e);
        }
        return json.toString();
    }
}
