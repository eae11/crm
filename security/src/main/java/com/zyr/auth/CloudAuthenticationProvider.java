package com.zyr.auth;

import com.zyr.common.entity.CloudUser;
import com.zyr.common.vo.SecurityUser;
import com.zyr.mapper.CloudUserMapper;
import com.zyr.service.impl.UserDetailsServiceImpl;
import com.zyr.set.Constants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 *   自定义认证处理
 */
@Component
public class CloudAuthenticationProvider implements AuthenticationProvider {

    @Resource
    UserDetailsServiceImpl userDetailsService;
    @Resource
    private CloudUserMapper cloudUserMapper;

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String accountName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        // 查看用户是否存在
        SecurityUser userInfo = (SecurityUser) userDetailsService.loadUserByUsername(accountName);
        if (userInfo == null) {
            throw new UsernameNotFoundException("登录的账户不存在，请确认");
        }
        // 我们还要判断密码是否正确，这里我们的密码使用BCryptPasswordEncoder进行加密的
        if (!new BCryptPasswordEncoder().matches(password, userInfo.getPassword())) {
            throw new BadCredentialsException("密码不正确,请检查");
        }

        if (userInfo.getLoginUser().getIsLock().equals("1")){
            throw new LockedException("该账号已被Lock");
        }
        // 角色
        String roleCodes = userInfo.getRole_en();
        String token = Jwts.builder().claim("role_login", roleCodes).setSubject(authentication.getName())
               .setExpiration(new Date(System.currentTimeMillis() + 25 * 60 * 1000))//单位毫秒
                .signWith(SignatureAlgorithm.HS512, Constants.SECURITY_SALT)
                .compact();

        CloudUser cloudUser = cloudUserMapper.selectById(userInfo.getLoginUser().getId());
        cloudUser.setLoginToken(token);
        cloudUserMapper.updateById(cloudUser);
        userInfo.getLoginUser().setLoginToken(token);
        return new UsernamePasswordAuthenticationToken(userInfo, password, userInfo.getAuthorities());
    }



}
