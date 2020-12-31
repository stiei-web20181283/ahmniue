package com.ahmniue.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 */
@Getter
@Setter
public class UmsAdminParam {
    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @Email
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "昵称")
    private String nickname;
}
