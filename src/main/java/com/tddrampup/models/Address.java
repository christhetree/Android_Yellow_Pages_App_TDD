
package com.tddrampup.models;

import com.google.gson.annotations.Expose;

public class Address {

    @Expose
    private String street;
    @Expose
    private String city;
    @Expose
    private String prov;
    @Expose
    private String pcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

}