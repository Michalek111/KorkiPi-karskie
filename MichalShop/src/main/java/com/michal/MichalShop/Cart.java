package com.michal.MichalShop;

import com.michal.MichalShop.model.Item;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart
{
private List<CartItem> cartItems = new ArrayList<>();
private int coutner =0;
private BigDecimal sum = BigDecimal.ZERO;

public void addItem(Item item)
{
    getCartItemByItem(item).ifPresentOrElse
            (CartItem::increaseCounter,()->cartItems.add
                    (new CartItem(item)));
    reacalculatePriceAndCouter();
}

public void decreaseItem(Item item)
{
    Optional<CartItem> oCartItem = getCartItemByItem(item);
    if(oCartItem.isPresent())
    {
        CartItem cartItem = oCartItem.get();
        cartItem.decreaseCounter();
        reacalculatePriceAndCouter();
        if(cartItem.hasZeroItem())
        {
            removeAllItems(item);
            reacalculatePriceAndCouter();

        }
    }
}

public void reacalculatePriceAndCouter()
{
    sum = cartItems.stream().map(CartItem::getPrice)
            .reduce(BigDecimal.ZERO,BigDecimal::add);
    coutner = cartItems.stream().mapToInt(CartItem::getCounter)
            .reduce(0,Integer::sum);
}
private Optional<CartItem> getCartItemByItem(Item item)
{
    return cartItems.stream()
            .filter(i->i.isEquals(item)).
            findFirst();
}


public void removeAllItems(Item item)
{
    cartItems.removeIf(i->i.isEquals(item));
    reacalculatePriceAndCouter();
}

public void clearCart()
{
    cartItems.clear();
    coutner=0;
    sum=BigDecimal.ZERO;
}


}
