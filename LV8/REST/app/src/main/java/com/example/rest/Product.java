package com.example.rest;

public class Product {
    private String image_link;
    private String name;
    private Float price;
    private Float rating;
    private String description;

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Float getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPrice(Float price) {
//        this.price = price;
//    }
//
//    public void setRating(Float rating) {
//        this.rating = rating;
//    }
//
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_link() {
        return image_link;
    }

}
