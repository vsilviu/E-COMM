package com.ecomm.controller;

import com.ecomm.dto.ItemFilterDTO;
import com.ecomm.dto.ResponseDTO;
import com.ecomm.entity.Item;
import com.ecomm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/find-all", method = RequestMethod.POST)
    public ResponseDTO findAllItemsFiltered(@RequestBody ItemFilterDTO itemFilter) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(itemService.findAllFiltered(itemFilter));
        return  responseDTO;
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public ResponseDTO updateItem(@RequestBody Item updatedItem) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(itemService.saveItem(updatedItem));
        return responseDTO;
    }

    @RequestMapping(value = "/count-cart-items", method = RequestMethod.GET)
    public ResponseDTO getTotalCartItemNumber() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(itemService.countCartItems());
        return responseDTO;
    }

}