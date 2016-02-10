package com.ecomm.repository;

import com.ecomm.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Set;

public interface ItemRepository extends MongoRepository<Item, String> {

    List<Item> findAllByInCartTrue();

    Set<Item> findAllByNameLike(String itemName);

}