package com.musahalilecer.orderservice.controller;

import com.musahalilecer.orderservice.dto.request.OrderRequest;
import com.musahalilecer.orderservice.dto.response.OrderResponse;
import com.musahalilecer.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(Integer id) {
        var order = orderService.getOrderById(id);
        if(order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(OrderRequest orderRequest){
        var order = orderService.createOrder(orderRequest);
        return ResponseEntity.ok(order);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable Integer id, OrderRequest orderRequest) {
        var order = orderService.getOrderById(id);
        if(order == null) {
            return ResponseEntity.notFound().build();
        }
        var updatedOrder = orderService.updateOrder(id, orderRequest);
        return ResponseEntity.ok(updatedOrder);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        var order = orderService.getOrderById(id);
        if(order == null) {
            new Exception("Order not found");
        }
        orderService.deleteOrder(id);
    }
    public ResponseEntity<List<OrderResponse>> findOrdersByStatus(String status){
        List<OrderResponse> orders = orderService.findOrdersByStatus(status);
        if(orders.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/status")
    public ResponseEntity<List<OrderResponse>> findOrderByStatus(String status){
        List<OrderResponse> getAllStatus = findOrdersByStatus(status).getBody();
        return ResponseEntity.ok(getAllStatus);
    }

/*
@Transactional(readOnly = true)
    public List<OrderResponse> findOrdersByStatus(String status) {
        OrderStatus st = OrderStatus.valueOf(status);
        return orderRepository.findByStatus(st).stream()
                .map(OrderMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end) {
        return orderRepository.findByCreatedAtBetween(start, end).stream()
                .map(OrderMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Long sumTotalAmountByCreatedAtBetween(LocalDateTime start, LocalDateTime end) {
        return orderRepository.sumTotalAmountByCreatedAtBetween(start, end);
    }
 */
}
