package com.happynacho.bookland;

public class Book {

    String title;
    String author;
    String category;
    String editorial;
    String description;
    String price;
    String url_image;

    public Book(){

    }

    public Book(String title, String author, String category, String editorial, String description, String price, String url_image) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.editorial = editorial;
        this.description = description;
        this.price = price;
        this.url_image = url_image;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl_image() {
        return url_image;
    }




}
