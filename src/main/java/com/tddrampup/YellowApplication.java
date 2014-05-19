package com.tddrampup;

import android.app.Application;

import roboguice.RoboGuice;

import static roboguice.RoboGuice.newDefaultRoboModule;
import static roboguice.RoboGuice.setBaseApplicationInjector;

public class YellowApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE, newDefaultRoboModule(this), new ApplicationModule());
    }
}
