/**
 * Copyright (c) Windliven 2016 All Rights Reserved
 *
 * @author liyj
 * @date 2017年7月11日 下午4:52:32
 * @since V1.0.0
 */
package com.spring.boot.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author liyj
 * @date 2017年7月11日 下午4:52:32
 *
 */
@EnableAutoConfiguration  
@ComponentScan(basePackages = "com.spring.boot")  
@Configuration
@MapperScan(value={"com.spring.boot.dao"})
public class StartMain {
    
    public static void main(String[] args) {
        SpringApplication.run(StartMain.class, args);
    }
}
