package com.tddrampup.fragments;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.inject.Inject;
import com.tddrampup.R;
import com.tddrampup.factories.CameraUpdateFactoryWrapperInterface;
import com.tddrampup.factories.MarkerOptionsFactoryWrapperInterface;
import com.tddrampup.models.Listing;
import com.tddrampup.singletons.ListingsInterface;

import roboguice.activity.RoboFragmentActivity;
import roboguice.fragment.RoboFragment;

/**
 * Created by WX009-PC on 2/19/14.
 */
public class GoogleMapFragment extends RoboFragment {

    public GoogleMap map;
    public GoogleMap.OnMyLocationChangeListener mListener;
    // TODO: ^ this is shit

    @Inject
    CameraUpdateFactoryWrapperInterface cameraUpdateFactory;

    @Inject
    MarkerOptionsFactoryWrapperInterface markerOptionsFactory;

    @Inject
    ListingsInterface mListings;

    public GoogleMapFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.google_map_fragment, container, false);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (map == null) {
            RoboFragmentActivity activity = (RoboFragmentActivity) getActivity();
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            map = ((SupportMapFragment) fragmentManager.findFragmentById(R.id.google_map)).getMap();
            if (map != null) {
                setupMap();
            }
        }
    }

    public void setupMap() {
        map.setMyLocationEnabled(true);
        addMarkers();
        mListener = new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                if (location != null) {
                    LatLng myLatLng = new LatLng(location.getLatitude(), location.getLongitude());
                    map.animateCamera(cameraUpdateFactory.newLatLngZoom(myLatLng, 15.f));
                    map.setOnMyLocationChangeListener(null);
                }
            }
        };
        map.setOnMyLocationChangeListener(mListener);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Fragment fragment = getFragmentManager().findFragmentById(R.id.google_map);
        if (fragment != null)
            getFragmentManager().beginTransaction().remove(fragment).commit();
    }

    public void addMarkers() {
        for(Listing tempListing : mListings.getListings()) {
            if (tempListing.getGeoCode() != null) {
                LatLng coordinates = new LatLng(Double.parseDouble(tempListing.getGeoCode().getLatitude()), Double.parseDouble(tempListing.getGeoCode().getLongitude()));
                map.addMarker(markerOptionsFactory.getOptions(tempListing.getName(), coordinates));
            }
        }
    }
}
