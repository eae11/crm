package com.zyr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyr.common.entity.CloudRole;
import com.zyr.common.entity.CloudUser;
import com.zyr.common.entity.CloudUserRole;
import com.zyr.common.vo.SecurityUser;
import com.zyr.mapper.CloudRoleMapper;
import com.zyr.mapper.CloudUserMapper;
import com.zyr.mapper.CloudUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * 认证用户
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CloudUserMapper cloudUserMapper;  //用户mapper
    @Autowired
    private CloudRoleMapper cloudRoleMapper; // 查询角色
    @Autowired
    private CloudUserRoleMapper cloudUserRoleMapper; //查询用户和角色对应的关系 ，是否含有该角色

    /***
     * 根据账号获取用户信息
     * @param accountName:
     * @return: org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        // 从数据库中取出用户信息
        List<CloudUser> userList = cloudUserMapper.selectList(new QueryWrapper<CloudUser>().eq("account_name", accountName));
        CloudUser user;
        // 判断用户是否存在
        if (!CollectionUtils.isEmpty(userList)) {
            user = userList.get(0);
        } else {
            throw new UsernameNotFoundException("用户名数据库未查到，请注册后再试！");
        }
        // 返回UserDetails实现类
        return new SecurityUser(user, getUserAndRole(user.getId()));
    }

    /***
     * 根据token获取用户权限
     *
     * @param token:
     */
    public SecurityUser checkAccountByToken(String token) {
        CloudUser user = null;
        List<CloudUser> loginList = cloudUserMapper.selectList(new QueryWrapper<CloudUser>().eq("login_token", token));
        if (!CollectionUtils.isEmpty(loginList)) {
            user = loginList.get(0);
        }
        return user != null ? new SecurityUser(user, getUserAndRole(user.getId())) : null;
    }

    /**
     *
     * 角色信息获取存储
     */
    private List<CloudRole> getUserAndRole(String  userId) {
        List<CloudUserRole> userRoles = cloudUserRoleMapper.selectList(new QueryWrapper<CloudUserRole>().eq("user_id", userId));
        List<CloudRole> roleList = new LinkedList<>();
        for (CloudUserRole userRole : userRoles) {
            CloudRole role = cloudRoleMapper.selectById(userRole.getRoleId());
            roleList.add(role);
        }
        return roleList;
    }

}
