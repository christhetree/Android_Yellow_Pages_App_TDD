package com.tddrampup.fragments;

import com.tddrampup.models.Address;
import com.tddrampup.models.Listing;
import com.tddrampup.singletons.FakeListings;
import com.tddrampup.singletons.Listings;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
public class ListingsTest {

    Listings mListings;

    public Listing fakeListing() {
        Listing fakeListing = new Listing();
        Address addOne = new Address();
        addOne.setCity(FakeListings.FakeData.CITY);
        addOne.setStreet(FakeListings.FakeData.STREET);
        fakeListing.setName(FakeListings.FakeData.NAME);
        fakeListing.setMerchantUrl(FakeListings.FakeData.MERCHANT_URL);
        fakeListing.setAddress(addOne);
        return fakeListing;
    }

    @Before
    public void setUp() throws Exception {
        mListings = new Listings();
    }

    @Test
    public void setListingsAndGetListings_shouldSetListingsAndReturnCorrectInformation() throws Exception {
        List<Listing> fakeListings = new ArrayList<Listing>();
        fakeListings.add(fakeListing());
        mListings.setListings(fakeListings);
        assertThat(mListings.getListings().get(0).getName()).isEqualTo("One");
        assertThat(mListings.getListings().get(0).getAddress().getStreet()).isEqualTo("Street");
        assertThat(mListings.getListings().get(0).getAddress().getCity()).isEqualTo("Toronto");
        assertThat(mListings.getListings().get(0).getMerchantUrl()).isEqualTo("www.herpaderp.com");
    }
}
