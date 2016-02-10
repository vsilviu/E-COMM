package com.ecomm.service;

import com.ecomm.entity.Order;

import java.util.List;

/**
 * Created by Silviu on 2/10/16.
 */
public interface OrderService {

    List<Order> findAll();
    void save(String itemId);
    void delete(String orderId);

}
