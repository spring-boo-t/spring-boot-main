/**
 * Copyright (c) Windliven 2016 All Rights Reserved
 *
 * @author liyj
 * @date 2017年7月12日 上午9:53:09
 * @since V1.0.0
 */
package com.spring.boot.base;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * TODO
 *
 * @author liyj
 * @date 2017年7月12日 上午9:53:09
 *
 */
@Configuration
@EnableTransactionManagement
public class DataBaseConfig {
    
    private final Logger log = LoggerFactory.getLogger(DataBaseConfig.class);
    
    @Bean
    @Primary
    public DataSource getDataSource() throws Exception {
        log.debug("config dataSource");
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/springboot");
        cpds.setUser("root");
        cpds.setPassword("root");
        return cpds;
    }
    
    @Bean
    public PlatformTransactionManager getTransactionManager() throws Exception {
        return new DataSourceTransactionManager(getDataSource());
    }
    
    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(getDataSource());
        sfb.setTypeAliasesPackage("com.spring.boot.entity");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sfb.setMapperLocations(resolver
                .getResources("classpath:/mapper/*.xml"));
        return sfb.getObject();
    }
    
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.mybloc.personal.mapper");
        msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return msc;
    }
}
