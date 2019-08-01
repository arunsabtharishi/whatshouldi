package com.dragonfly.whatshouldi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class, JmsAutoConfiguration.class})
public class WhatShouldIApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WhatShouldIApplication.class);
        app.run(args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
