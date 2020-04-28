package com.sam.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sam.dao")
public class MybatisPlusConfig {
}
