package com.michal.MichalShop.mapper;

import com.michal.MichalShop.Cart;
import com.michal.MichalShop.CartItem;
import com.michal.MichalShop.dto.OrderDto;
import com.michal.MichalShop.model.order.Order;
import com.michal.MichalShop.model.order.OrderItem;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{
    public static Order maptoOrder(OrderDto orderDto)
    {
return Order.builder()
        .firstName(orderDto.getFirstName())
        .lastName(orderDto.getLastName())
        .address(orderDto.getAddress())
        .postCode(orderDto.getPostCode())
        .city(orderDto.getCity())
        .created(LocalDateTime.now())
        .build();
    }

    public static List<OrderItem> mapToOrderItemList(Cart cart, Order order)
    {
        List<OrderItem> orderItems = new ArrayList<>();
        for(CartItem ci : cart.getCartItems())
        {
            orderItems.add(new OrderItem(order.getOrderId(), ci.getItem().getId(),ci.getCounter()));
        }
        return orderItems;
    }
}
