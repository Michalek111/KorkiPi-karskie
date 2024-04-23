package com.michal.MichalShop.controler;

import com.michal.MichalShop.Cart;
import com.michal.MichalShop.ItemOperation;
import com.michal.MichalShop.model.Item;
import com.michal.MichalShop.respository.ItemRepository;
import com.michal.MichalShop.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController
{

    private final CartService cartService;

    public HomeController(CartService cartService)
    {
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String home(Model model)
    {
       // List<Item> items = itemRepository.findAll();
        model.addAttribute("items",cartService.getAllItems());

        return "home";

    }

    @GetMapping("/add/{itemId}")

    public String addItemToCart(@PathVariable("itemId")long itemId, Model model)
    {
       cartService.itemOperation(itemId, ItemOperation.INCREASE);
        model.addAttribute("items",cartService.getAllItems());
        //return "home";
       return "redirect:/";
    }

}
