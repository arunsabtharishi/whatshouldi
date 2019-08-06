package com.dragonfly.whatshouldi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class, JmsAutoConfiguration.class})
@ComponentScan(basePackages = { "com.dragonfly.whatshouldi" })
@EnableConfigurationProperties

public class WhatShouldIApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WhatShouldIApplication.class);
        app.run(args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
