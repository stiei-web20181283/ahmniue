package com.ahmniue.manage.config;

import com.ahmniue.common.config.BaseSwaggerConfig;
import com.ahmniue.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.ahmniue.manage.controller")
                .title("ahmniue后台管理")
                .description("ahmniue后台相关接口文档")
                .contactName("Lexcubia")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
