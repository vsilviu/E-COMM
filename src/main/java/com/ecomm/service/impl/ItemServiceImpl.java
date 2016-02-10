package com.ecomm.service.impl;

import com.ecomm.dto.ItemFilterDTO;
import com.ecomm.entity.Item;
import com.ecomm.entity.NomCategory;
import com.ecomm.repository.ItemRepository;
import com.ecomm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Silviu on 2/10/16.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Set<Item> findAllFiltered(ItemFilterDTO filterDTO) {
        //compromise for not knowing too well mongo queries
        Set<Item> items = itemRepository.findAllByNameLike(filterDTO.getName());
        Set<Item> results = new HashSet<Item>();

        if(filterDTO.getCategory() != null) {
            for(Item item : items) {
                for(NomCategory category : item.getCategories()) {
                    if(category.getId().equals(filterDTO.getCategory().getId())) {
                        results.add(item);
                        break;
                    }
                }
            }
        } else {
            results = items;
        }
        return results;
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Long countCartItems() {
        List<Item> cartItems = itemRepository.findAllByInCartTrue();
        return (long) cartItems.size();
    }
}
