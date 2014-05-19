package com.tddrampup.singletons;

import com.tddrampup.models.Listing;

import java.util.List;

/**
 * Created by WX009-PC on 2/19/14.
 */
public interface ListingsInterface {

//    public static Listings getInstance();
    public List<Listing> getListings();
    public void setListings(List<Listing> value);
    public String getWhatQuery();
    public void setWhatQuery(String whatQuery);
    public String getWhereQuery();
    public void setWhereQuery(String whereQuery);
}
