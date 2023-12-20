package com.homs4j.shop.app.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Product {
    private String productId;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private Long unitsInStock;
    private Long unitsInOrder;
    private enum condition {NEW,RENEWED};
    private Boolean discontinued;
    private Category category;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Product() {
    }

    public Product(String productId, String name, String description, BigDecimal unitPrice, Long unitsInStock, Long unitsInOrder, Boolean discontinued, Category category, Timestamp createdAt, Timestamp updatedAt) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsInOrder = unitsInOrder;
        this.discontinued = discontinued;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Long getUnitsInOrder() {
        return unitsInOrder;
    }

    public void setUnitsInOrder(Long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
