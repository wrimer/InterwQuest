package com.dev.rairet.interwquest.di.application;

import android.content.Context;
import android.util.Log;

import com.dev.rairet.interwquest.Configuration;
import com.dev.rairet.interwquest.data.db.InterwQuestDb;
import com.dev.rairet.interwquest.data.storage.MemoryStorage;
import com.dev.rairet.interwquest.util.DatabaseDestroyer;
import com.huma.room_for_asset.RoomAsset;

import java.io.File;

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
        DatabaseDestroyer.deleteDb(context);
        return RoomAsset.databaseBuilder(ctx,
                InterwQuestDb.class, Configuration.DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    MemoryStorage provideMemoryStorage() {
        return new MemoryStorage();
    }
}
