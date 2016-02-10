package com.ecomm.service;

import com.ecomm.dto.ItemFilterDTO;
import com.ecomm.entity.Item;

import java.util.Set;

/**
 * Created by Silviu on 2/10/16.
 */
public interface ItemService {

    Set<Item> findAllFiltered(ItemFilterDTO filterDTO);

    Item saveItem(Item item);

    Long countCartItems();

}
