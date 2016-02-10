package com.ecomm.dto;

import com.ecomm.entity.NomCategory;

import java.io.Serializable;

/**
 * Created by Silviu on 2/7/16.
 */
public class ItemFilterDTO implements Serializable {

    private String name;
    private NomCategory category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NomCategory getCategory() {
        return category;
    }

    public void setCategory(NomCategory category) {
        this.category = category;
    }
}
