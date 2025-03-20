package org.example.khanhshop.entity;

import jakarta.persistence.*;
import org.example.khanhshop.enums.EShipmentStatus;

@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_number ")
    private String trackingNumber; //mã vận đơn

    private String carrier; //đơn vị vận chuyển

    @Enumerated(EnumType.STRING)
    private EShipmentStatus status;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;




}
