package com.zyr.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 自定义认证管理器
 */
@Component
public class CloudAuthenticationManager implements AuthenticationManager {

    private final CloudAuthenticationProvider cloudAuthenticationProvider;

    public  CloudAuthenticationManager(CloudAuthenticationProvider cloudAuthenticationProvider) {
        this.cloudAuthenticationProvider = cloudAuthenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication result = cloudAuthenticationProvider.authenticate(authentication);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new ProviderNotFoundException("权限验证失败，请确认数据库或者菜单是否授权!");
    }

}
