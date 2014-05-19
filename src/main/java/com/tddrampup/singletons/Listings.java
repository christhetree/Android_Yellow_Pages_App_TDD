package com.tddrampup.singletons;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tddrampup.models.Listing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WX009-PC on 2/19/14.
 */
@Singleton
public class Listings implements ListingsInterface {

    private List<Listing> mListings;
    private String mWhatQuery;
    private String mWhereQuery;

    @Inject
    public Listings() {
        mListings = new ArrayList<Listing>();
    }

    public List<Listing> getListings(){
        return this.mListings;
    }

    public void setListings(List<Listing> value){
        mListings = value;
    }

    public String getWhatQuery() {
        return this.mWhatQuery;
    }

    public void setWhatQuery(String whatQuery) {
        this.mWhatQuery = whatQuery;
    }

    public String getWhereQuery() {
        return mWhereQuery;
    }

    public void setWhereQuery(String whereQuery) {
        this.mWhereQuery = whereQuery;
    }

//    public Listing getListing(){
//        return this.mListing;
//    }
//
//    public void setListing(Listing value){
//        mListing = value;
//    }
}
