package com.michal.MichalShop.model.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class OrderItem
{
    @Id
    @GeneratedValue
    private long orderItemId;
    private long orderId;
    private long itemId;
    private int amont;

    public OrderItem(long orderId, long itemId, int amont) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.amont = amont;
    }
}
