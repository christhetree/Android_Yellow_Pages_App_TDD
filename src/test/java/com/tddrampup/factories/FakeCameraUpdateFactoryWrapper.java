package com.tddrampup.factories;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.LatLng;

import static org.mockito.Mockito.mock;

/**
 * Created by WX009-PC on 2/25/14.
 */
public class FakeCameraUpdateFactoryWrapper implements CameraUpdateFactoryWrapperInterface {

    public LatLng mLatLng;
    public float mZoom;

    @Override
    public CameraUpdate newLatLngZoom(LatLng latLng, float zoom) {
        mLatLng = latLng;
        mZoom = zoom;
        return mock(CameraUpdate.class);
    }
}
