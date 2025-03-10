package org.example.khanhshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Coupons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Double discountAmount;

    private Boolean isActive; // trạng thai co kich hoat hay khong

// thiếu

    @CreationTimestamp
    private LocalDateTime startDate;

    @UpdateTimestamp
    private LocalDateTime endDate;
}
