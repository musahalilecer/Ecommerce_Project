package com.musahalilecer.orderservice.mapper;

import com.musahalilecer.orderservice.dto.request.OrderRequest;
import com.musahalilecer.orderservice.dto.response.OrderResponse;
import com.musahalilecer.orderservice.model.Item;
import com.musahalilecer.orderservice.model.Order;
import com.musahalilecer.orderservice.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderMapper {

    public static Order toEntity(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderStatus(orderRequest.getOrderStatus());
        order.setCreatedAt(orderRequest.getCreatedAt());
        order.setTotalAmount(orderRequest.getTotalAmount());
        return order;
    }

    public static OrderResponse toResponse(Order order) {
        Set<Integer> itemIds = order.getItems().stream()
                .map(Item::getId)
                .collect(Collectors.toSet());

        return new OrderResponse(
                order.getId(),
                order.getCreatedAt(),
                order.getTotalAmount(),
                order.getOrderStatus(),
                itemIds
        );
    }
    
}
