package com.order.service.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.order.service.entity.PurchaseOrder;

public interface OrderRepository extends JpaRepository<PurchaseOrder,Integer> {
}