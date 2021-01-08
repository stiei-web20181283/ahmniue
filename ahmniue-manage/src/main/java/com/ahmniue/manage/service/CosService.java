package com.ahmniue.manage.service;

import java.io.File;
/**
 * Cos对象存储管理Service
 * Created by Lexcubia on 2021/1/8.
 */
public interface CosService {
    /**
     * 单个文件上传
     * @param file
     * @return
     */
    String upload(File file);
}
