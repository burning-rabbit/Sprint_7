package org.example.models;

import java.util.List;

public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private Integer rentTime;
    private String deliveryDate;
    private String comment;
    private List<String> color;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getRentTime() {
        return rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public List<String> getColor() {
        return color;
    }

    public Order withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Order withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Order withAddress(String address) {
        this.address = address;
        return this;
    }

    public Order withMetroStation(String metroStation) {
        this.metroStation = metroStation;
        return this;
    }

    public Order withRentTime(Integer rentTime) {
        this.rentTime = rentTime;
        return this;
    }

    public Order withDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public Order withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Order withColor(List<String> color) {
        this.color = color;
        return this;
    }

    public Order withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
