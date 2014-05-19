package com.tddrampup.models;

import com.google.gson.annotations.Expose;

public class GeoCode {

    @Expose
    private String latitude;
    @Expose
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}