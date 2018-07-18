package com.dev.rairet.interwquest;

import android.app.Application;

import com.dev.rairet.interwquest.di.application.AppComponent;
import com.dev.rairet.interwquest.di.application.AppModule;
import com.dev.rairet.interwquest.di.application.DaggerAppComponent;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
    }

    //=====================================================================================
    // *** Dagger ***
    //=====================================================================================
    private static AppComponent appComponent;

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getComponent() {
        return appComponent;
    }
}
