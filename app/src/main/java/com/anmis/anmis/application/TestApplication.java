package com.anmis.anmis.application;

import android.app.Application;

import com.anmis.adfaf.DaoMaster;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by nsw on 2016/11/18 15:03 .
 */

public class TestApplication extends Application {

    private static TestApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Fresco.initialize(this);
    }

    public static TestApplication getInstance() {
        return app;
    }
}
