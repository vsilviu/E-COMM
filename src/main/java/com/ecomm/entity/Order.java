package com.ecomm.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * Created by Silviu on 2/10/16.
 */
@Document
public class Order {
    @Id
    private String id;
    private Item item;
    private Long orderedQuantity = 0L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(Long orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }
}
