package com.ecomm.repository;

import com.ecomm.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {

    List<Item> findAllByInCartTrue();

    List<Item> findAllByNameLike(String itemName);

}