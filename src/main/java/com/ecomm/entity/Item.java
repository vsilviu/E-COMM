package com.ecomm.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigInteger;
import java.util.List;

@Document
public class Item {

    @Id
    private String id;

    private boolean inCart;
    private String name;
    private Double price;
    private List<NomCategory> categories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<NomCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<NomCategory> categories) {
        this.categories = categories;
    }
}