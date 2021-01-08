package com.ahmniue.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * cos上传文件的回调结果
 * Created by Lexcubia on 2021/1/9.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CosCallbackResult {
    @ApiModelProperty("文件名称")
    private String filename;
    @ApiModelProperty("文件地址")
    private String path;
}
