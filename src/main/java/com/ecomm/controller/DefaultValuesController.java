package com.ecomm.controller;

import com.ecomm.entity.Item;
import com.ecomm.entity.NomCategory;
import com.ecomm.repository.CategoryRepository;
import com.ecomm.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silviu on 2/10/16.
 */
@RestController
@RequestMapping(value = "/default-init")
public class DefaultValuesController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/init-db", method = RequestMethod.GET)
    public void initDatabase() {
        clearDatabase();
        createDefaultCategories();
        createDefaultItems();
    }

    public void createDefaultCategories() {
        List<NomCategory> categories = new ArrayList<NomCategory>();

        NomCategory category = new NomCategory();
        category.setId(1L);
        category.setName("Category 1");
        category.setCode("CAT_1");
        categories.add(category);

        category = new NomCategory();
        category.setId(2L);
        category.setName("Category 2");
        category.setCode("CAT_2");
        categories.add(category);

        category = new NomCategory();
        category.setId(3L);
        category.setName("Category 3");
        category.setCode("CAT_3");
        categories.add(category);

        categoryRepository.save(categories);
    }

    public void createDefaultItems() {
        for (int i = 1; i <= 4; ++i) {
            Item item = new Item();
//            item.setId(new Long(i));
            item.setInCart(false);
            item.setName("Item " + i);
            item.setPrice(2 * i + Math.sqrt(5 * i));
            List<NomCategory> categories = new ArrayList<NomCategory>();
            long firstValue = (long) ((int) (Math.random() * 3) + 1);
            long secondValue = (long) ((int) (Math.random() * 3) + 1);
            while(secondValue == firstValue) {
                secondValue = (long) ((int) (Math.random() * 3) + 1);
            }
            categories.add(categoryRepository.findOne(firstValue));
            categories.add(categoryRepository.findOne(secondValue));
            item.setCategories(categories);
            itemRepository.save(item);
        }
    }

    public void createDefaultOrders() {

    }

    public void clearDatabase() {
        itemRepository.deleteAll();
        categoryRepository.deleteAll();
    }

}
