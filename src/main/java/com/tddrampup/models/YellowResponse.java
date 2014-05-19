package com.tddrampup.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class YellowResponse {

    @Expose
    private Summary summary;
    @Expose
    private List<Listing> listings = new ArrayList<Listing>();

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }

}
