package com.dev.rairet.interwquest.di.activity;

import com.dev.rairet.interwquest.business.QuestionInteractor;
import com.dev.rairet.interwquest.business.ThemesInteractor;
import com.dev.rairet.interwquest.data.db.InterwQuestDb;
import com.dev.rairet.interwquest.repositories.QuestionRepository;
import com.dev.rairet.interwquest.repositories.ThemesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class ThemesModule {
    @Provides
    @ActivityScope
    ThemesRepository provideThemesRepository (InterwQuestDb db){
        return new ThemesRepository(db);
    }

    @Provides
    @ActivityScope
    ThemesInteractor provideThemesInteractor(ThemesRepository themesRepository){
        return new ThemesInteractor(themesRepository);
    }
}
