package com.ahmniue.manage.controller;

import com.ahmniue.common.api.CommonResult;
import com.ahmniue.generator.model.User;
import com.ahmniue.manage.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台用户管理Controller
 */
@Controller
@Api(tags = "UserController", description = "后台用户管理")
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取全部用户")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<User>> getList() {
        return CommonResult.success(userService.listAllUser());
    }
}
