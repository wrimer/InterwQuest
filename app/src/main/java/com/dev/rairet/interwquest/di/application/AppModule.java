package com.dev.rairet.interwquest.di.application;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.dev.rairet.interwquest.Configuration;
import com.dev.rairet.interwquest.data.db.InterwQuestDb;
import com.huma.room_for_asset.RoomAsset;

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

    @Provides
    @Singleton
    InterwQuestDb provideDatabase(Context ctx) {
        return  RoomAsset.databaseBuilder(ctx,
                InterwQuestDb.class, Configuration.DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }
}
