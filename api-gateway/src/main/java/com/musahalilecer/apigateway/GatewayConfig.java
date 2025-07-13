package com.musahalilecer.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Product Service
                .route("product-service", r -> r
                        .path("/products/**")
                        .filters(f -> f
                                .rewritePath("/products/(?<segment>.*)", "/${segment}")
                        )
                        .uri("lb://product-service")
                )
                // Customer Service
                .route("customer-service", r -> r
                        .path("/customers/**")
                        .filters(f -> f
                                .rewritePath("/customers/(?<segment>.*)", "/${segment}")
                        )
                        .uri("lb://customer-service")
                )
                // Order Service
                .route("order-service", r -> r
                        .path("/orders/**")
                        .filters(f -> f
                                .rewritePath("/orders/(?<segment>.*)", "/${segment}")
                        )
                        .uri("lb://order-service")
                )
                .build();
    }
}
