package com.homs4j.shop.app.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
    private String orderId;
    private BigDecimal totalPrice;
    private User user;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Order() {
    }

    public Order(String orderId, BigDecimal totalPrice, User user, Timestamp createdAt, Timestamp updatedAt) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
