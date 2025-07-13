package com.musahalilecer.orderservice.dto.request;

import com.musahalilecer.orderservice.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequest {
    private List<Integer> itemIds;

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Integer> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    private Long totalAmount;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;

}
