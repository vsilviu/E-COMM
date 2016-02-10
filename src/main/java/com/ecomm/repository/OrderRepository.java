package com.ecomm.repository;

import com.ecomm.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by Silviu on 2/10/16.
 */
public interface OrderRepository extends MongoRepository<Order, String> {

    @Query("{item : {'_id': ?0 }}")
    public Order findByItem_id(String itemId);

}
