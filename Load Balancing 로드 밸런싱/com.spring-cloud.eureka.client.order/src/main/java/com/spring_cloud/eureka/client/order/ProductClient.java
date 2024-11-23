package com.spring_cloud.eureka.client.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "product-service")
public interface ProductClient {
    /*
    실제 Product App 의 엔드포인트를 호출
     */
    @GetMapping("/product/{id}")
    String getProduct(@PathVariable("id") String id);

}
