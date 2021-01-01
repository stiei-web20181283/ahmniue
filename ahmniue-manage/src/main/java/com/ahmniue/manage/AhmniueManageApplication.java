package com.ahmniue.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动入口
 */
//@MapperScan("com.ahmniue.common.service")

@SpringBootApplication(scanBasePackages = "com.ahmniue")
//@ComponentScan("com.ahmniue")
public class AhmniueManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(AhmniueManageApplication.class, args);
    }
}
