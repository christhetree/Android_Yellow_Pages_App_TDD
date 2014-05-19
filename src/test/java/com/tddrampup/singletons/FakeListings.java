package com.tddrampup.singletons;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tddrampup.models.Address;
import com.tddrampup.models.GeoCode;
import com.tddrampup.models.Listing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WX009-PC on 2/24/14.
 */
@Singleton
public class FakeListings implements ListingsInterface {

    public class FakeData {
        public static final String CITY = "Toronto";
        public static final String STREET = "Street";
        public static final String NAME = "One";
        public static final String MERCHANT_URL = "www.herpaderp.com";
        public static final String LATITUDE = "53.558";
        public static final String LONGITUDE = "9.927";
    }

    private List<Listing> mListings;

    @Inject
    public FakeListings() {
        mListings = new ArrayList<Listing>();
        createFakeData();
    }

    public void createFakeData(){
            Listing one = new Listing();
            Address addOne = new Address();
            addOne.setCity(FakeData.CITY);
            addOne.setStreet(FakeData.STREET);
            one.setName(FakeData.NAME);
            one.setMerchantUrl(FakeData.MERCHANT_URL);
            one.setAddress(addOne);
            GeoCode coordinates = new GeoCode();
            coordinates.setLatitude(FakeData.LATITUDE);
            coordinates.setLongitude(FakeData.LONGITUDE);
            one.setGeoCode(coordinates);
            ArrayList<Listing> listings = new ArrayList<Listing>();
            listings.add(one);
            setListings(listings);
    }

    public List<Listing> getListings(){
        return this.mListings;
    }

    public void setListings(List<Listing> value){
        mListings = value;
    }

    @Override
    public String getWhatQuery() {
        return null;
    }

    @Override
    public void setWhatQuery(String whatQuery) {

    }

    @Override
    public String getWhereQuery() {
        return null;
    }

    @Override
    public void setWhereQuery(String whereQuery) {

    }
}
