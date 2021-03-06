package com.dev.rairet.interwquest.di.activity;

import com.dev.rairet.interwquest.business.QuestionInteractor;
import com.dev.rairet.interwquest.data.db.InterwQuestDb;
import com.dev.rairet.interwquest.repositories.QuestionRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class QuestionModule {

    @Provides
    @ActivityScope
    QuestionRepository provideQuestionRepository(InterwQuestDb db){
        return new QuestionRepository(db);
    }

    @Provides
    @ActivityScope
    QuestionInteractor provideQuestionInteractor(QuestionRepository questionRepository){
        return new QuestionInteractor(questionRepository);
    }
}
