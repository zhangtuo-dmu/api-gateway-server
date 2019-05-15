package edu.dlmu.sei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by zhangtuo on 2019-05-14.
 */
@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayBootStrap.class, args);
    }
}
