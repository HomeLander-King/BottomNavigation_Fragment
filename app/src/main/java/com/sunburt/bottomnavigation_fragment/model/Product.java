package com.sunburt.bottomnavigation_fragment.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int img;
    private String name;
    private float price;
    private String descr;

    public Product() {
    }

    public Product(int img, String name, float price, String descr) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.descr = descr;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
