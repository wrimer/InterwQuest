package com.dev.rairet.interwquest.di.activity;

import com.dev.rairet.interwquest.presentation.home.HomePresenter;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {
        QuestionModule.class
})
public interface ActivityComponent {

    void inject(HomePresenter presenter);
}
