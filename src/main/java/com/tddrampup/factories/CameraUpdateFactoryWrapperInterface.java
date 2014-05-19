package com.tddrampup.factories;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by WX009-PC on 2/25/14.
 */
public interface CameraUpdateFactoryWrapperInterface {
    public CameraUpdate newLatLngZoom(LatLng latLng, float zoom);
}
