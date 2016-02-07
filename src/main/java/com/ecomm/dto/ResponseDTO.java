package com.ecomm.dto;

import java.io.Serializable;

/**
 * Created by Silviu on 2/7/16.
 */
public class ResponseDTO implements Serializable {

    private String status;
    private String notification;
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
