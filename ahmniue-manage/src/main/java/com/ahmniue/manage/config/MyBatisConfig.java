package com.ahmniue.manage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.ahmniue.generator.mapper","com.ahmniue.manage.dao"})
public class MyBatisConfig {
}
