package com.musahalilecer.orderservice.service;

import com.musahalilecer.orderservice.dto.request.OrderRequest;
import com.musahalilecer.orderservice.dto.response.OrderResponse;
import com.musahalilecer.orderservice.mapper.ItemMapper;
import com.musahalilecer.orderservice.mapper.OrderMapper;
import com.musahalilecer.orderservice.model.Item;
import com.musahalilecer.orderservice.model.Order;
import com.musahalilecer.orderservice.model.OrderStatus;
import com.musahalilecer.orderservice.repository.ItemRepository;
import com.musahalilecer.orderservice.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderResponse getOrderById(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
        return OrderMapper.toResponse(order);
    }

    @Transactional
    public OrderResponse createOrder(OrderRequest request) {
        List<Item> items = itemRepository.findAllById(request.getItemIds()).stream()
                .peek(item -> item.setOrder(null))
                .collect(Collectors.toList());

        Long total = request.getTotalAmount() != null
                ? request.getTotalAmount()
                : items.stream().mapToLong(Item::getCost).sum();

        LocalDateTime createdAt = request.getCreatedAt() != null
                ? request.getCreatedAt()
                : LocalDateTime.now();

        Order order = OrderMapper.toEntity(request);
        order.setTotalAmount(total);
        order.setCreatedAt(createdAt);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toResponse(savedOrder);
    }

    @Transactional
    public OrderResponse updateOrder(Integer id, OrderRequest request) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));

        existing.setOrderStatus(request.getOrderStatus());

        Long totalAmount = request.getTotalAmount() != null
                ? request.getTotalAmount()
                : existing.getItems().stream().mapToLong(Item::getCost).sum();

        existing.setCreatedAt(
                request.getCreatedAt() != null ? request.getCreatedAt() : existing.getCreatedAt()
        );
        List<Item> newItems = itemRepository.findAllById(request.getItemIds()).stream()
                .peek(item -> item.setOrder(existing))
                .collect(Collectors.toList());
        existing.getItems().clear();
        existing.getItems().addAll(newItems);

        Order updatedOrder = orderRepository.save(existing);
        return OrderMapper.toResponse(updatedOrder);
    }

    @Transactional
    public void deleteOrder(Integer id) {
        if (!orderRepository.existsById(id)) {
            throw new EntityNotFoundException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }

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
}

/*

    @Transactional
    public OrderResponse updateOrder(Integer id, OrderRequest request) {
        Order existing = orderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));

        // Statü güncelle
        existing.setStatus(OrderStatus.valueOf(request.getStatus()));

        // TotalAmount güncelle
        Long total = request.getTotalAmount() != null
            ? request.getTotalAmount()
            : existing.getItems().stream().mapToLong(Item::getCost).sum();
        existing.setTotalAmount(total);

        // Tarih güncelle
        existing.setCreatedAt(
            request.getCreatedAt() != null ? request.getCreatedAt() : existing.getCreatedAt()
        );

        // Item listesi güncelle
        Set<Item> newItems = itemRepository.findAllById(request.getItemIds()).stream()
            .peek(item -> item.setOrder(existing))
            .collect(Collectors.toSet());
        existing.getItems().clear();
        existing.getItems().addAll(newItems);

        Order updated = orderRepository.save(existing);
        return OrderMapper.toResponse(updated);
    }
 */
