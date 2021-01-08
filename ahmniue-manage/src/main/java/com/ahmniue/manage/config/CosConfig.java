package com.ahmniue.manage.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;

/**
 * COS对象存储相关配置
 * Created by Lexcubia on 2021/1/8.
 */
public class CosConfig {
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

    public COSClient cosClient(){
        COSCredentials cosCredentials = new BasicCOSCredentials(TENCENT_COS_SECRETID, TENCENT_COS_SECRETKEY);
        ClientConfig clientConfig = new ClientConfig(new Region(TENCENT_COS_REGION));
        return new COSClient(cosCredentials,clientConfig);
    }
}
