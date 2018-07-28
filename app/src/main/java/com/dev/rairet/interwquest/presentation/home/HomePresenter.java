package com.dev.rairet.interwquest.presentation.home;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.dev.rairet.interwquest.App;
import com.dev.rairet.interwquest.business.ThemesInteractor;
import com.dev.rairet.interwquest.data.db.entities.Theme;
import com.dev.rairet.interwquest.presentation.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class HomePresenter extends BasePresenter<HomeView> {

    @Inject
    ThemesInteractor themesInteractor;

    public HomePresenter() {
        App.getComponent().activityComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getThemesList();
    }

    private void getThemesList() {
        obsContainer.add(themesInteractor.getAllThemes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> getViewState().showThemes(response)
                ));
    }

    public void onThemeClick(Theme theme) {
        Log.i("sf","sdf");
    }
}
