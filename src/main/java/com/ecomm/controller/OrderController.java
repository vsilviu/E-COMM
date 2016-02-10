package com.ecomm.controller;

import com.ecomm.dto.ResponseDTO;
import com.ecomm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Silviu on 2/10/16.
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/save/{itemId}", method = RequestMethod.POST)
    public void saveOrder(@PathVariable String itemId) {
        orderService.save(itemId);
    }

    @RequestMapping(value = "/find-all", method = RequestMethod.GET)
    public ResponseDTO findAllOrders() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(orderService.findAll());
        return responseDTO;
    }

    @RequestMapping(value = "/delete/{orderId}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable String orderId) {
        orderService.delete(orderId);
    }

}
