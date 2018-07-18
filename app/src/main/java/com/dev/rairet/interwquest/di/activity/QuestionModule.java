package com.dev.rairet.interwquest.di.activity;

import com.dev.rairet.interwquest.business.questions.QuestionInteractor;
import com.dev.rairet.interwquest.repositories.questions.QuestionRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class QuestionModule {

    @Provides
    @ActivityScope
    QuestionRepository provideQuestionRepository(){
        return new QuestionRepository();
    }

    @Provides
    @ActivityScope
    QuestionInteractor provideQuestionInteractor(QuestionRepository questionRepository){
        return new QuestionInteractor(questionRepository);
    }
}
