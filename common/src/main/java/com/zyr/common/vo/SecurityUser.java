package com.zyr.common.vo;


import com.zyr.common.entity.CloudRole;
import com.zyr.common.entity.CloudUser;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

/**
 *  获取登录用户的详情信息，UserDetails是系统自带的
 *  知识点transient：
 *  常常会遇到这样的问题，这个类的有些属性需要序列化，而其他属性不需要被序列化，
 *  打个比方，如果一个用户有一些敏感信息（如密码，银行卡号等），为了安全起见，
 *  不希望在网络操作（主要涉及到序列化操作，本地序列化缓存也适用）中被传输，
 *  这些信息对应的变量就可以加上transient关键字。这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化。
 */
@Data
@Slf4j
public class SecurityUser implements UserDetails, Serializable {
    /**
     * 当前login用户
     */
    private transient CloudUser loginUser;
    /**
     * 角色
     */
    private transient List<CloudRole> roleList;
    /**
     * 角色代号
     */
    private transient String role_en;

    /**
     * 状态:0正常  1禁用
     */
    private String isLock;

    public SecurityUser() { }

    public SecurityUser(CloudUser user) {
        if (user != null) {
            this.loginUser = user;
        }
    }

    public SecurityUser(CloudUser user, List<CloudRole> roleList) {
        if (user != null) {
            this.loginUser = user;
            this.roleList = roleList;
            if (!CollectionUtils.isEmpty(roleList)){
                StringJoiner roleCodes = new StringJoiner(",", "[", "]");
                roleList.forEach(e -> roleCodes.add(e.getRoleEn()));
                this.role_en = roleCodes.toString();
            }
        }
    }

    /**
     * 当前登录用户的角色合集
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (!CollectionUtils.isEmpty(this.roleList)) {
            for (CloudRole role : this.roleList) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleEn());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return loginUser.getPassWord();
    }

    @Override
    public String getUsername() {
        return loginUser.getAccountName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
