package com.ahmniue.manage.controller;

import com.ahmniue.common.api.CommonResult;
import com.ahmniue.manage.dto.CosCallbackResult;
import com.ahmniue.manage.service.CosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@Api(tags = "CosController", description = "腾讯云cos对象存储")
@RequestMapping("/cos")
public class CosController {
    @Autowired
    private CosService cosService;

    @ApiOperation(value = "单个文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CosCallbackResult> upload(@RequestBody MultipartFile file) {
        if (file == null){
            return null;
        } else {
            CosCallbackResult url = cosService.upload(file);
            return CommonResult.success(url);
        }
    }
}
