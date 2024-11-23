package com.spring_cloud.eureka.client.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;

    public String getProductInfo(String productId) {
        return productClient.getProduct(productId);
    }

    /*
    1번 주문 들어오면 상품 2번 정보 불러옴
     */
    public String getOrder(String orderId) {
        if(orderId.equals("1") ){
            String productId = "2";
            String productInfo = getProductInfo(productId);
            return "[ORDER ID] " + orderId + " [PRODUCT INFO] " + productInfo;

        }
        return "Not exist order...";
    }
}