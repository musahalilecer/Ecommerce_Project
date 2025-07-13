package com.musahalilecer.orderservice.dto.response;

import com.musahalilecer.orderservice.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class OrderResponse {

    private Integer id;
    private List<Integer> itemIds;
    private Long totalAmount;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;

    public <R> OrderResponse(Integer id, LocalDateTime createdAt, Long totalAmount, OrderStatus orderStatus, R r) {
    }
}
