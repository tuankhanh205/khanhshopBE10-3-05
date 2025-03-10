package org.example.khanhshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {  // Đổi từ `Payments` thành `Payment` để đúng với quy tắc đặt tên (số ít)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // Liên kết với đơn hàng đã thanh toán

    @Column(nullable = false)
    private String paymentMethod; // VD: CREDIT_CARD, PAYPAL, CASH

    @Column(nullable = false)
    private String status; // PENDING, COMPLETED, FAILED

    @Column(unique = true)
    private String transactionId; // Mã giao dịch nếu có (dùng cho PayPal, ngân hàng, v.v.)

    @Column
    private LocalDateTime createdAt; // Ngày thanh toán
}
