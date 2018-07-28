package com.dev.rairet.interwquest.presentation.home;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.dev.rairet.interwquest.App;
import com.dev.rairet.interwquest.data.db.InterwQuestDb;
import com.dev.rairet.interwquest.presentation.base.BasePresenter;

import javax.inject.Inject;

@InjectViewState
public class HomePresenter extends BasePresenter<HomeView> {

    @Inject
    InterwQuestDb dataBase;

    public HomePresenter() {
        App.getComponent().activityComponent().inject(this);
    }

}
