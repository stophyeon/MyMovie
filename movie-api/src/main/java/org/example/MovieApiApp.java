package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableDiscoveryClient
@RefreshScope
@EnableFeignClients
public class MovieApiApp {
    public static void main(String[] args) {
        SpringApplication.run(MovieApiApp.class, args);
    }
}