package com.michal.MichalShop.service;

import com.michal.MichalShop.Cart;
import com.michal.MichalShop.dto.OrderDto;
import com.michal.MichalShop.mapper.OrderMapper;
import com.michal.MichalShop.model.order.Order;
import com.michal.MichalShop.respository.order.OrderItemRepository;
import com.michal.MichalShop.respository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
    private final Cart cart;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderService(Cart cart, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public void saveOrder(OrderDto orderDto)
    {
        Order order = OrderMapper.maptoOrder(orderDto);
        orderRepository.save(order);
        orderItemRepository.saveAll(OrderMapper.mapToOrderItemList(cart,order));
        cart.clearCart();
    }
}
