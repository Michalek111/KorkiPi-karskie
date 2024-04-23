package com.michal.MichalShop.model.order;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="orders")
public class Order
{
    @Id
    @GeneratedValue
    private long orderId;
    private String firstName;
    private String lastName;
    private String address;
    private String postCode;
    private String city;
    private LocalDateTime created;

@OneToMany
    @JoinColumn(name="orderId")
    private List<OrderItem> orderItems;
}
