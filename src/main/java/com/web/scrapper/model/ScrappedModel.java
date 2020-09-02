package com.web.scrapper.model;

public class ScrappedModel {
    private String name;
    private String url;
    private String price;
    private String discount;

    public ScrappedModel() {
    }

    public ScrappedModel(String name, String url, String price, String discount) {
        this.name = name;
        this.url = url;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}