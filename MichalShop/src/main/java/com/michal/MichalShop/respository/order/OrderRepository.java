package com.michal.MichalShop.respository.order;

import com.michal.MichalShop.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
