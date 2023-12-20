package com.homs4j.shop.app.models;

import java.sql.Timestamp;

public class State {
    private String stateId;
    private String name;
    private Country country;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public State(String stateId, String name, Country country, Timestamp createdAt, Timestamp updatedAt) {
        this.stateId = stateId;
        this.name = name;
        this.country = country;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public State() {
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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
