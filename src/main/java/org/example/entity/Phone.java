package org.example.entity;

public class Phone {
    private int phoneid;
    private String brand;
    private String model;
    private double price;
    private int storageCapacity;
    private String color;
    private double screenSize;
    private int batteryCapacity;

    public Phone(String brand, String model, double price, int storageCapacity, String color, double screenSize, int batteryCapacity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.storageCapacity = storageCapacity;
        this.color = color;
        this.screenSize = screenSize;
        this.batteryCapacity = batteryCapacity;
    }

    public Phone(int phoneid, String brand, String model, double price, int storageCapacity, String color, double screenSize, int batteryCapacity) {
        this.phoneid = phoneid;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.storageCapacity = storageCapacity;
        this.color = color;
        this.screenSize = screenSize;
        this.batteryCapacity = batteryCapacity;
    }

    public int getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(int phoneid) {
        this.phoneid = phoneid;
    }

    public Phone() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneid=" + phoneid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", storageCapacity=" + storageCapacity +
                ", color='" + color + '\'' +
                ", screenSize=" + screenSize +
                ", batteryCapacity=" + batteryCapacity +
                '}';
    }
}
