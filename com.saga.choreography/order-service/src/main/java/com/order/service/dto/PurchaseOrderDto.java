package com.order.service.dto;

import com.common.enums.OrderStatus;
import com.common.enums.PaymentStatus;
import com.order.service.entity.PurchaseOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Data Transfer Object for PurchaseOrder entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseOrderDto {

    private Integer orderId;
    private Integer userId;
    private Integer productId;
    private Integer price;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;

    /**
     * Convert Entity to DTO
     */
    public static PurchaseOrderDto entityToDto(PurchaseOrder entity) {
        if (entity == null) {
            return null;
        }
        PurchaseOrderDto dto = new PurchaseOrderDto();
        dto.setOrderId(entity.getOrderId());
        dto.setUserId(entity.getUserId());
        dto.setProductId(entity.getProductId());
        dto.setPrice(entity.getPrice());
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setPaymentStatus(entity.getPaymentStatus());
        return dto;
    }

    /**
     * Convert DTO to Entity
     */
    public static PurchaseOrder dtoToEntity(PurchaseOrderDto dto) {
        if (dto == null) {
            return null;
        }
        PurchaseOrder entity = new PurchaseOrder();
        entity.setOrderId(dto.getOrderId());
        entity.setUserId(dto.getUserId());
        entity.setProductId(dto.getProductId());
        entity.setPrice(dto.getPrice());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setPaymentStatus(dto.getPaymentStatus());
        return entity;
    }
}
