package com.dev.rairet.interwquest.presentation.base;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<T extends MvpView> extends MvpPresenter<T> {

    protected CompositeDisposable obsContainer;

    public BasePresenter() {
        obsContainer = new CompositeDisposable();
    }

    @Override
    public void onDestroy() {
        obsContainer.clear();
        super.onDestroy();
    }
}
