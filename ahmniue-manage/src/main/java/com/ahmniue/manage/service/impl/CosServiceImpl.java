package com.ahmniue.manage.service.impl;

import com.ahmniue.manage.service.CosService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
/**
 * Cos对象存储管理Service实现类
 * Created by Lexcubia on 2021/1/8.
 */
public class CosServiceImpl implements CosService {
//    private static final Logger LOGGER = LoggerFactory.getLogger(CosServiceImpl.class);
    @Value("${tencent.secretId}")
    private String TENCENT_COS_SECRETID;
    @Value("${tencent.secretKey}")
    private String TENCENT_COS_SECRETKEY;
    @Value("${tencent.region}")
    private String TENCENT_COS_REGION;
    @Value("${tencent.bucketName}")
    private String TENCENT_COS_BUCKETNAME;
    @Value("${tencent.path}")
    private String TENCENT_COS_PATH;
    @Value("${tencent.prefix}")
    private String TENCENT_COS_PREFIX;
    @Override
    public String upload(File file) {
        //生成唯一文件名
        String fileName = generateUniqueName(file.getName());
        // 存储目录
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dir = TENCENT_COS_PREFIX +sdf.format(new Date());
        //文件在存储桶中的key
        String key = dir + fileName;
        // 创建COS 凭证
        COSCredentials credentials = new BasicCOSCredentials(TENCENT_COS_SECRETID,TENCENT_COS_SECRETKEY);
        // 配置 COS 区域
        ClientConfig clientConfig = new ClientConfig(new Region(TENCENT_COS_REGION));
        // 创建 COS 客户端连接
        COSClient cosClient = new COSClient(credentials,clientConfig);
        try {
            // 将 文件上传至 COS
            PutObjectRequest objectRequest = new PutObjectRequest(TENCENT_COS_BUCKETNAME,key,file);
            cosClient.putObject(objectRequest);
        }catch (Exception e){
            e.printStackTrace();
//            LOGGER.error("上传失败", e);
        }finally {
            cosClient.shutdown();
        }
        return TENCENT_COS_PATH+fileName;
    }
    /**
     * 根据UUID生成唯一文件名
     * @param originalName
     * @return
     */
    public String generateUniqueName(String originalName) {
        return UUID.randomUUID() + originalName.substring(originalName.lastIndexOf("."));
    }
}
