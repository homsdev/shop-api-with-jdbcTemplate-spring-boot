package com.homs4j.shop.app.models;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Category {
    private String categoryId;
    private String name;
}
