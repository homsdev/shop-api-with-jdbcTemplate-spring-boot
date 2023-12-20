package com.homs4j.shop.app.models;

import java.sql.Timestamp;

public class Category {
    private String categoryId;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Category() {
    }

    public Category(String categoryId, String name, Timestamp createdAt, Timestamp updatedAt) {
        this.categoryId = categoryId;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
