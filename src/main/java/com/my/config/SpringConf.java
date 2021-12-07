package com.my.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Replacement of applicationContextMvc xml
 */

@Configuration
@EnableJpaRepositories("com.my.repository")
@EntityScan(basePackages = "com.my.entity")
@EnableWebMvc
@EnableTransactionManagement
public class SpringConf implements WebMvcConfigurer {

    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
        viewResolver.setPrefix("/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/beauty_salon_2")
                .username("root")
                .password("1111")
                .build();
    }
    @Bean
    public JavaMailSenderImpl mailSender() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        JavaMailSenderImpl jmsi= new JavaMailSenderImpl();
        jmsi.setHost("smtp.gmail.com");
        jmsi.setPort(587);
        jmsi.setUsername("b24963@gmail.com");
        jmsi.setPassword("123456B_o");
        jmsi.setJavaMailProperties(props);

        return jmsi;
    }

}



