package com.tddrampup.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Listing{

    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private Address address;
    @Expose
    private List<Phone> phones = new ArrayList<Phone>();
    @Expose
    private GeoCode geoCode;
    @Expose
    private Products products;
    @Expose
    private String merchantUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public GeoCode getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public String getMerchantUrl() {
        return merchantUrl;
    }

    public void setMerchantUrl(String merchantUrl) {
        this.merchantUrl = merchantUrl;
    }

}