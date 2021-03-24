package me.hwanseok.simplemsaorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SimpleMsaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleMsaOrderApplication.class, args);
    }

}
