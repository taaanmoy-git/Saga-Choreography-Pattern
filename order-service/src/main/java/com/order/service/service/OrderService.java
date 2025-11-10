package com.order.service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.dto.OrderRequestDto;
import com.common.enums.OrderStatus;
import com.order.service.dto.PurchaseOrderDto;
import com.order.service.entity.PurchaseOrder;
import com.order.service.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusPublisher orderStatusPublisher;

    @Transactional
    public PurchaseOrderDto createOrder(OrderRequestDto orderRequestDto) {
        PurchaseOrder order = orderRepository.save(convertDtoToEntity(orderRequestDto));
        orderRequestDto.setOrderId(order.getOrderId());
        //produce kafka event with status ORDER_CREATED
        orderStatusPublisher.publishOrderEvent(orderRequestDto, OrderStatus.ORDER_CREATED);
        
        PurchaseOrderDto purchaseOrderDto = PurchaseOrderDto.entityToDto(order);
        return purchaseOrderDto;
    }

    public List<PurchaseOrderDto> getAllOrders(){
        return orderRepository.findAll().stream()
        		.map(entity-> PurchaseOrderDto.entityToDto(entity))
        		.collect(Collectors.toList())
        		;
    }


    private PurchaseOrder convertDtoToEntity(OrderRequestDto dto) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setUserId(dto.getUserId());
        purchaseOrder.setProductId(dto.getProductId());
        purchaseOrder.setOrderStatus(OrderStatus.ORDER_CREATED);
        purchaseOrder.setPrice(dto.getAmount());
        return purchaseOrder;
    }
}