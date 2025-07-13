package com.musahalilecer.orderservice.dto.response;

import com.musahalilecer.orderservice.model.Order;

public class ItemResponse {

    private Integer id;
    private String itemName;
    private Integer orderId;
    private Long cost;

    public ItemResponse(Integer id, String itemName, Order order, Long cost) {
    }
}
