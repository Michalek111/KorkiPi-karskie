package com.michal.MichalShop.respository.order;

import com.michal.MichalShop.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
