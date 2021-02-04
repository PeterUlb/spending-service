package io.mybartab.spendingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpendingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpendingServiceApplication.class, args);
    }
}
