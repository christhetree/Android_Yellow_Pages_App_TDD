package com.tddrampup.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WX009-PC on 2/21/14.
 */
public class Products {

    @Expose
    private List<String> webUrl = new ArrayList<String>();
    @Expose
    private List<Object> dispAd = new ArrayList<Object>();
    @Expose
    private List<Object> photos = new ArrayList<Object>();
    @Expose
    private List<Profile> profiles = new ArrayList<Profile>();

    public List<String> getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(List<String> webUrl) {
        this.webUrl = webUrl;
    }

    public List<Object> getDispAd() {
        return dispAd;
    }

    public void setDispAd(List<Object> dispAd) {
        this.dispAd = dispAd;
    }

    public List<Object> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Object> photos) {
        this.photos = photos;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

}