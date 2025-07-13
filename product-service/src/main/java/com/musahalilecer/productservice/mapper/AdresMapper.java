package com.musahalilecer.productservice.mapper;

import com.musahalilecer.productservice.dto.request.AdressRequest;
import com.musahalilecer.productservice.dto.response.AdressResponse;
import com.musahalilecer.productservice.dto.response.CountryResponse;
import com.musahalilecer.productservice.model.Adress;

import java.util.Optional;

public class AdresMapper {

    public static Adress toEntity(AdressRequest req) {
        Adress a = new Adress();
        a.setAdressLocation(req.getAdressLocation());
        // country set in service layer
        return a;
    }

    public static AdressResponse toResponse(Adress adress) {
        return new AdressResponse(
                adress.getAdressLocation(),
                adress.getCountry()
        );
        /*
        AdressResponse.AdressResponseBuilder b = AdressResponse.builder()
                .id(adress.getId())
                .adressLocation(adress.getAdressLocation());

        Optional.ofNullable(adress.getCountry()).ifPresent(c ->
                b.countryId(c.getId())
        );
        return b.build();

         */
    }
}

/*
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
 */
