package com.michal.MichalShop.service;

import com.michal.MichalShop.Cart;
import com.michal.MichalShop.ItemOperation;
import com.michal.MichalShop.model.Item;
import com.michal.MichalShop.respository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService
{
    private final ItemRepository itemRepository;
    private final Cart cart;

    @Autowired
    public CartService(ItemRepository itemRepository,Cart cart)
    {
        this.itemRepository = itemRepository;
        this.cart = cart;
    }

    public List<Item> getAllItems()
    {
        return itemRepository.findAll();
    }


public void itemOperation(Long itemId, ItemOperation itemOperation)
{
Optional<Item> oItem = itemRepository.findById(itemId);
if(oItem.isPresent())
    {
    Item item = oItem.get();
        switch(itemOperation)
        {
            case INCREASE -> cart.addItem(item);
            case DECREASE -> cart.decreaseItem(item);
            case REMOVE -> cart.removeAllItems(item);
            default -> throw new IllegalArgumentException();
        }
    }
}

}
