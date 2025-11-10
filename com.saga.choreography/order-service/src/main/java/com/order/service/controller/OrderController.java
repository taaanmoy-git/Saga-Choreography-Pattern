package com.order.service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.common.dto.OrderRequestDto;
import com.order.service.dto.PurchaseOrderDto;
import com.order.service.entity.PurchaseOrder;
import com.order.service.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/create")
    public PurchaseOrderDto createOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.createOrder(orderRequestDto);
    }

    @GetMapping
    public List<PurchaseOrderDto> getOrders(){
        return orderService.getAllOrders();
    }
}