package com.pair.nkweb.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(value = "com.pair.nkweb.mappers2", sqlSessionFactoryRef = "mySqlSessionFactory")
@PropertySource("classpath:db.properties")
@EnableAspectJAutoProxy
public class Root2Config {

    @Value("${mysql.id}")
    private String user;

    @Value("${mysql.password}")
    private String password;

    @Value("${mysql.url}")
    private String url;

    @Bean(name = "myDataSource")
    public DataSource dataSource2() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(5);
        dataSource.setMaxTotal(5);
        dataSource.setValidationQuery("select 1");
        dataSource.setPoolPreparedStatements(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);


        return dataSource;
    }

    @Bean(name = "mySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();


        sqlSessionFactoryBean.setDataSource(dataSource2());

        return sqlSessionFactoryBean.getObject();
    }


    @Bean(name = "mysqlSession")
    public SqlSession sqlSession() throws Exception {

        SqlSession sqlSession = new SqlSessionTemplate(sqlSessionFactory());

        return sqlSession;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() throws Exception {


        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();


        transactionManager.setDataSource(dataSource2());

        return transactionManager;
    }



    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws Exception {

        return new PropertySourcesPlaceholderConfigurer();
    }
}
