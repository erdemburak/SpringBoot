package com.burakerdem.controller.bean;

import com.burakerdem.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean(initMethod = "initialBeanMethod", destroyMethod = "destroyBeanMethod")
    @Scope("singleton") //Singleton, Request
    public BeanDto beanDto(){
        return BeanDto.builder().id(0L).beanName("Bean Adi").beanData("Bean Data").build();
    }
}
