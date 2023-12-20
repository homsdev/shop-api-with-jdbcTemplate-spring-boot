package com.homs4j.shop.app.models;

import java.math.BigDecimal;

public class OrderDetail {
    private String orderDetailId;
    private Long quantity;
    private BigDecimal price;
    private Product product;
    private Order order;
}
