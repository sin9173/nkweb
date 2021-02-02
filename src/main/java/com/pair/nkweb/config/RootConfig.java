package com.pair.nkweb.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.pair.nkweb.mappers"}, sqlSessionFactoryRef = "sapSqlSessionFactory")
@ComponentScan("com.pair.nkweb.service")
@ComponentScan("com.pair.nkweb.security")
@PropertySource("classpath:db.properties")
@PropertySource("classpath:security.properties")
@EnableAspectJAutoProxy
public class RootConfig {
    

    @Value("${sap.user}")
    private String user;

    @Value("${sap.password}")
    private String password;

    @Value("${sap.url}")
    private String url;

    @Value("${sap.driverClassName}")
    private String driverClassName;

    @Bean(name="sapDataSource")
    @Primary
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(5);
        dataSource.setMaxTotal(5);
        dataSource.setValidationQuery("select 1");

        return dataSource;
    }


    @Bean(name = "sapSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource());

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSession")
    @Primary
    public SqlSession sqlSession() throws Exception{
        SqlSession sqlSession = new SqlSessionTemplate(sqlSessionFactory());

        return sqlSession;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() throws Exception {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();

        transactionManager.setDataSource(dataSource());

        return transactionManager;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
