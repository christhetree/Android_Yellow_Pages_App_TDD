package com.tddrampup.factories;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by WX009-PC on 2/25/14.
 */
public class MarkerOptionsFactoryWrapper implements MarkerOptionsFactoryWrapperInterface {
    @Override
    public MarkerOptions getOptions(String name, LatLng latLng) {
        return new MarkerOptions()
                    .position(latLng)
                    .title(name);
    }
}
