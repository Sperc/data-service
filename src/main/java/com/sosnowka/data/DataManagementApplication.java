package com.sosnowka.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DataManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataManagementApplication.class, args);
    }
}
