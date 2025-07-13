package com.musahalilecer.orderservice.mapper;

import com.musahalilecer.orderservice.dto.request.ItemRequest;
import com.musahalilecer.orderservice.dto.response.ItemResponse;
import com.musahalilecer.orderservice.model.Item;
import com.musahalilecer.orderservice.model.Order;

import java.util.List;

public class ItemMapper {

    public static Item toEntity(ItemRequest request) {
        Item item = new Item();
        item.setItemName(request.getItemName());
        item.setCost(request.getCost());
        return item;
    }

    public static ItemResponse toResponse(Item item) {
        return new ItemResponse(
                item.getId(),
                item.getItemName(),
                item.getOrder(),
                item.getCost()
        );
    }
}
