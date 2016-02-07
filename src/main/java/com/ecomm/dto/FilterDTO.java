package com.ecomm.dto;

import java.io.Serializable;

/**
 * Created by Silviu on 2/7/16.
 */
public class FilterDTO implements Serializable {

    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
