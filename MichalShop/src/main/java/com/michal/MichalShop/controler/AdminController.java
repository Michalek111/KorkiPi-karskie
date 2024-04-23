package com.michal.MichalShop.controler;

import com.michal.MichalShop.model.Item;
import com.michal.MichalShop.model.order.Order;
import com.michal.MichalShop.respository.ItemRepository;
import com.michal.MichalShop.respository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")


public class AdminController
{
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public AdminController(ItemRepository itemRepository, OrderRepository orderRepository)
    {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }
    @GetMapping
    private String adminPage()
    {
        return "adminView/addItem";
    }
@PostMapping
    private String addItem(Item item)
{
    itemRepository.save(item);
    return "redirect:/";
}

@GetMapping("/showorders")
    @ResponseBody
    public List<Order> showOrders()
{
    return orderRepository.findAll();
}
}
