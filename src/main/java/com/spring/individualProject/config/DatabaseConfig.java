package com.spring.individualProject.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.spring.individualProject")
public class DatabaseConfig {
    //DB접속정보 설정 (= DataSource설정)
    @Bean
    public DataSource dataSource() {
        //커넥션 풀: 연결객체를 풀에 담아두고 재활용
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        config.setUsername("indi1");
        config.setPassword("1234");
        return new HikariDataSource(config);
    }
}
