package org.example.entity;

public class Product {
    private int pid;
    private String pname;
    private String brand;
    private String category;
    private double price;
    private int rating;
    private int discount;

    public Product(int pid, String pname, String brand, String category, double price, int rating, int discount) {
        this.pid = pid;
        this.pname = pname;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public Product(String pname, String brand, String category, double price, int rating, int discount) {
        this.pname = pname;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public Product() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", discount=" + discount +
                '}';
    }
}
