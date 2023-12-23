package com.homs4j.shop.app.models;

import com.homs4j.shop.app.enums.Condition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productId;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private Long unitsInStock;
    private Long unitsInOrder;
    private Condition condition;
    private Boolean discontinued;
    private Category category;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
