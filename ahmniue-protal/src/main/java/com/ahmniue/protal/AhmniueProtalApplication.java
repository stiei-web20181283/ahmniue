package com.ahmniue.protal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动入口
 */
//@MapperScan("com.ahmniue.common.service")

@SpringBootApplication(scanBasePackages = "com.ahmniue")
//@ComponentScan("com.ahmniue")
public class AhmniueProtalApplication {
    public static void main(String[] args) {
        SpringApplication.run(AhmniueProtalApplication.class, args);
    }
}
