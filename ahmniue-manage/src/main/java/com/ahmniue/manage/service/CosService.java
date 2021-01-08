package com.ahmniue.manage.service;

import com.ahmniue.manage.dto.CosCallbackResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
/**
 * Cos对象存储管理Service
 * Created by Lexcubia on 2021/1/8.
 */
public interface CosService {
    /**
     * 单个文件上传
     */
    CosCallbackResult upload(MultipartFile file);
}
