package org.example.khanhshop.enums;

public enum EShipmentStatus {
    PENDING,       // Đang chờ xử lý
    SHIPPED,       // Đã giao cho đơn vị vận chuyển
    IN_TRANSIT,    // Đang vận chuyển
    DELIVERED,     // Đã giao hàng thành công
    CANCELED,      // Đơn vận chuyển bị hủy
    RETURNED       // Hàng bị trả lại
}
