package com.spring_cloud.eureka.client.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    /*
    애플리케이션이 실행중인 포트 주입
     */
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/product")
    public String getProduct() {
        return "port : " + serverPort ;
    }

}
