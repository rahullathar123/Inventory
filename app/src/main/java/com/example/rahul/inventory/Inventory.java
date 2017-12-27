package com.example.rahul.inventory;

/**
 * Created by rahul on 2017-12-26.
 */

public class Inventory {

    public long id;
    int quantity,restockQuantity,price;
    public String name;

    public Inventory(long id, int quantity, int restockQuantity, int price, String name) {
        this.id = id;
        this.quantity = quantity;
        this.restockQuantity = restockQuantity;
        this.price = price;
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int  quantity) {
        this.quantity = quantity;
    }

    public int getRestockQuantity() {
        return restockQuantity;
    }

    public void setRestockQuantity(int restockQuantity) {
        this.restockQuantity = restockQuantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
