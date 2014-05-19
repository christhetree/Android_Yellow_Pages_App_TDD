package com.tddrampup;

import com.google.inject.AbstractModule;
import com.tddrampup.factories.CameraUpdateFactoryWrapperInterface;
import com.tddrampup.factories.FakeCameraUpdateFactoryWrapper;
import com.tddrampup.factories.FakeMarkerOptionsFactoryWrapper;
import com.tddrampup.factories.MarkerOptionsFactoryWrapperInterface;
import com.tddrampup.singletons.FakeListings;
import com.tddrampup.singletons.ListingsInterface;

/**
 * Created by WX009-PC on 2/24/14.
 */
public class TestApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ListingsInterface.class).to(FakeListings.class);
        bind(CameraUpdateFactoryWrapperInterface.class).to(FakeCameraUpdateFactoryWrapper.class);
        bind(MarkerOptionsFactoryWrapperInterface.class).to(FakeMarkerOptionsFactoryWrapper.class);
    }
}
