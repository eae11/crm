package com.zyr.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyr.common.entity.CloudMenu;
import com.zyr.common.entity.CloudRole;
import com.zyr.common.entity.CloudRoleMenu;
import com.zyr.mapper.CloudMenuMapper;
import com.zyr.mapper.CloudRoleMapper;
import com.zyr.mapper.CloudRoleMenuMapper;
import com.zyr.set.IgnoreUrlConfig;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 用户角色权限信息
 */
@Component
public class CloudUrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    CloudMenuMapper cloudMenuMapper;
    @Resource
    CloudRoleMenuMapper cloudRoleMenuMapper;
    @Resource
    CloudRoleMapper cloudRoleMapper;
    @Resource
    IgnoreUrlConfig ignoreUrlConfig;

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //放行的url过滤
        for (String ignoreUrl : ignoreUrlConfig.getNocheck().getIgnoreUrls()) {
            if (ignoreUrl.equals(requestUrl)) {
                return null;
            }
        }

        if (requestUrl.contains("/login")) {
            return null;
        }

        // 查询数据库DB所有url
        List<CloudMenu> permissionList = cloudMenuMapper.selectList(null);
        for (CloudMenu permission : permissionList) {
            // 获取该url所对应的权限
            if ((permission.getMenuPath()).equals(requestUrl)) {
                List<CloudRoleMenu> permissions = cloudRoleMenuMapper.selectList(new QueryWrapper<CloudRoleMenu>().eq("menu_id", permission.getId()));
                List<String> roles = new LinkedList<>();
                if (!CollectionUtils.isEmpty(permissions)) {
                    permissions.forEach(e -> {
                        Long roleId = e.getRoleId();
                        CloudRole role = cloudRoleMapper.selectById(roleId);
                        roles.add(role.getRoleEn());
                    });
                }
                // 角色-权限信息的集合处理
                return SecurityConfig.createList(roles.toArray(new String[roles.size()]));
            }
        }

        return SecurityConfig.createList("role_login");
    }


}
