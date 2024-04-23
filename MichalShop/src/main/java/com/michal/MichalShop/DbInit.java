package com.michal.MichalShop;

import com.michal.MichalShop.model.Item;
import com.michal.MichalShop.respository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner
{
    private final ItemRepository itemRepository;


    @Autowired
    public DbInit(ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        itemRepository.saveAll(List.of(
        new Item("Adidas X 17.1 FG", new BigDecimal("999.99"),
                "https://gfx.r-gol.com/media/res/products/456/118456/adidas-x-17-1-fg-s82287_1.png"),
        new Item ("Nike Mercurial Vapor 14 Elite FG ",new BigDecimal("1199.99"),
                "https://gfx.r-gol.com/media/res/products/835/147835/465x605/nike-mercurial-vapor-14-elite-fg_1.jpg"),
        new Item("Adidas X speedportal+ FG",new BigDecimal("1299.99"),
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNJSCiOmBcmLFfoJvsnjQ0nNIcbYtmvujl00ui3nGfVNxzTTnxfVLYlsGU5ZVo3f5lPoY&usqp=CAU"),
                new Item ("Korki Puma Future Ultimate L FG/AG", new BigDecimal("759.99"),
                "https://gfx.r-gol.com/media/res/products/376/165376/795x1035/107169-03_1.jpg")
        ));
    }
}
