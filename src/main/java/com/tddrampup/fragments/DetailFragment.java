package com.tddrampup.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tddrampup.R;
import com.tddrampup.models.Listing;

import roboguice.fragment.RoboFragment;

/**
 * Created by WX009-PC on 2/21/14.
 */
public class DetailFragment extends RoboFragment {

    private Listing mListing;
    private TextView nameTextView;
    private TextView locationTextView;
    private TextView websiteTextView;

    public DetailFragment(Listing listing) {
        mListing = listing;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.detail_fragment, container, false);
        nameTextView = (TextView) rootView.findViewById(R.id.name_detail_fragment);
        locationTextView = (TextView) rootView.findViewById(R.id.location_detail_fragment);
        websiteTextView = (TextView) rootView.findViewById(R.id.website_detail_fragment);
        populateTextViews();
        return rootView;
    }

    public void populateTextViews() {
        nameTextView.setText(mListing.getName());
        locationTextView.setText(mListing.getAddress().getStreet() + ", " + mListing.getAddress().getCity() + ", " + mListing.getAddress().getProv() + ", " + mListing.getAddress().getPcode());
        websiteTextView.setText(mListing.getMerchantUrl());
    }
}
