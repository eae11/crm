package com.zyr.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.zyr.common.entity.CloudUser;
import com.zyr.common.vo.CloudResult;
import com.zyr.service.CloudUserService;
import com.zyr.service.impl.CloudUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
用户管理
 */
@RestController
@RequestMapping(value = "/rest/user")
@Api(value = "用户操作接口", tags = "用户操作接口")
public class CloudUserController extends ApiController {
    @Autowired
    private CloudUserService cloudUserService;
    @Autowired
    private UserDetailsService userDetailsService;
    @RequestMapping(value = "/list")
    @ApiOperation(value = "用户列表", httpMethod = "POST")
    public CloudResult getlist() {
        List<CloudUser> cloudUserList = cloudUserService.list();

        return CloudResult.createByCodeSuccess(200, "用户列表查询成功", cloudUserList);
    }

}
