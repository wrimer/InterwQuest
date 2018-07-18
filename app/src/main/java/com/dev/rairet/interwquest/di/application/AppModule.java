package com.dev.rairet.interwquest.di.application;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class AppModule {
    private Context context;

    public AppModule(Context ctx) {
        context = ctx.getApplicationContext();
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return context;
    }
}
