package com.dev.rairet.interwquest.di.application;

import com.dev.rairet.interwquest.di.activity.ActivityComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class
})
public interface AppComponent {
    ActivityComponent activityComponent();
}