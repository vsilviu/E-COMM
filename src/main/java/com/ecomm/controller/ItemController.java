package com.ecomm.controller;

import com.ecomm.entity.Item;
import com.ecomm.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public List findItems() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item addItem(@RequestBody Item item) {
        item.setId(null);
        return repo.save(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Item updateItem(@RequestBody Item updatedItem, @PathVariable String id) {
        updatedItem.setId(id);
        return repo.save(updatedItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable String id) {
        repo.delete(id);
    }

    @RequestMapping(value = "/add_item_dummies", method = RequestMethod.GET)
    public void addDummyItemsInDb() {
        for (int i = 1; i <= 4; ++i) {
            Item item = new Item();
            item.setId((new Integer(i)).toString());
            item.setInCart(false);
            item.setName("Laptop " + i);
            item.setPrice(2 * i + Math.sqrt(5 * i));
            repo.save(item);
        }
    }

    @RequestMapping(value = "/clear_db", method = RequestMethod.GET)
    public void clearDb() {
        repo.deleteAll();
    }

}