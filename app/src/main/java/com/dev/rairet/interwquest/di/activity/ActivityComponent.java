package com.dev.rairet.interwquest.di.activity;

import com.dev.rairet.interwquest.presentation.home.HomePresenter;
import com.dev.rairet.interwquest.presentation.questions.QuestionsPresenter;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {
        QuestionModule.class,
        ThemesModule.class
})
public interface ActivityComponent {

    void inject(HomePresenter presenter);

    void inject(QuestionsPresenter presenter);
}
