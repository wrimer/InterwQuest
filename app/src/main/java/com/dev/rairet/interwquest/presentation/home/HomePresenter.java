package com.dev.rairet.interwquest.presentation.home;

import com.arellomobile.mvp.InjectViewState;
import com.dev.rairet.interwquest.App;
import com.dev.rairet.interwquest.presentation.base.BasePresenter;

@InjectViewState
public class HomePresenter extends BasePresenter<HomeView> {

    public HomePresenter() {
        App.getComponent().activityComponent().inject(this);
    }
}
