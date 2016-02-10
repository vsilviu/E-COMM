package com.ecomm.service.impl;

import com.ecomm.entity.Order;
import com.ecomm.repository.ItemRepository;
import com.ecomm.repository.OrderRepository;
import com.ecomm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Silviu on 2/10/16.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(String itemId) {
        //compromis pt lipsa de cunostinte queriuri
        Order dbOrder = new Order();

        List<Order> allOrders = orderRepository.findAll();

        for(Order order : allOrders) {
            if(order.getItem().getId().equals(itemId)) {
                dbOrder = order;
            }
        }

        if(dbOrder.getId() == null) {
            dbOrder.setItem(itemRepository.findOne(itemId));
        }

        dbOrder.setOrderedQuantity(dbOrder.getOrderedQuantity() + 1);
        orderRepository.save(dbOrder);
    }

}
