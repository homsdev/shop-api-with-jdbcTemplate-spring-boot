package com.homs4j.shop.app.models;

import java.sql.Timestamp;

public class Country {
    private String countryId;
    private String isoCode;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Country() {
    }

    public Country(String countryId, String isoCode, Timestamp createdAt, Timestamp updatedAt) {
        this.countryId = countryId;
        this.isoCode = isoCode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
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
