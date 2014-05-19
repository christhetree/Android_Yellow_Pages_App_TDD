package com.tddrampup.factories;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static org.mockito.Mockito.mock;

/**
 * Created by WX009-PC on 2/25/14.
 */
public class FakeMarkerOptionsFactoryWrapper implements MarkerOptionsFactoryWrapperInterface {

    public String mName;
    public LatLng mLatLng;

    @Override
    public MarkerOptions getOptions(String name, LatLng latLng) {
        mName = name;
        mLatLng = latLng;
        return mock(MarkerOptions.class);
    }
}
