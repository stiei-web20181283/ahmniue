package com.ahmniue.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动入口
 */
@MapperScan("com.ahmniue.common.service")
@SpringBootApplication
public class AhmniueManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(AhmniueManageApplication.class, args);
    }
}
