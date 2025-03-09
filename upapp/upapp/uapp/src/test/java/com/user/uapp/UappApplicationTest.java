package com.user.uapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class UappApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        // This test will check if the application context loads successfully
    }

    @Test
    public void restTemplateBeanIsCreated() {
        // Check if the RestTemplate bean is created
        RestTemplate restTemplate = applicationContext.getBean(RestTemplate.class);
        assertThat(restTemplate).isNotNull();
    }
}