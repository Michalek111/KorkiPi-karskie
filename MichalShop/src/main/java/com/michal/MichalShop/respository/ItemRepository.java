package com.michal.MichalShop.respository;

import com.michal.MichalShop.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository  extends JpaRepository<Item,Long>
{
}
