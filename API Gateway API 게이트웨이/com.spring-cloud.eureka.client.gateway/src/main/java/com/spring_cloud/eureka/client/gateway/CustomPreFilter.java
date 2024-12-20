package com.spring_cloud.eureka.client.gateway;

import java.util.logging.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CustomPreFilter implements GlobalFilter, Ordered {

    private static final Logger logger = Logger.getLogger(CustomPreFilter.class.getName());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest response = exchange.getRequest();
        logger.info("Pre Filter: Request URI is " + response.getURI());
        /*
        Add any custom logic here
         */
        /*
        이상이 없으면 다음 필터로 전달
         */
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        /*
        제일 먼저 실행
         */
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
