package com.dev.rairet.interwquest.presentation.questions;

import com.arellomobile.mvp.InjectViewState;
import com.dev.rairet.interwquest.App;
import com.dev.rairet.interwquest.data.db.InterwQuestDb;
import com.dev.rairet.interwquest.data.db.entities.Theme;
import com.dev.rairet.interwquest.presentation.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class QuestionsPresenter extends BasePresenter<QuestionsView> {

    @Inject
    InterwQuestDb db;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        obsContainer.add(db.questionDao().getQuestionsByTheme(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(questions -> {
                    getViewState().showQuestions(questions);
                }));
    }

    public void onQuestionClick(Theme item) {
    }

    public QuestionsPresenter() {
        App.getComponent().activityComponent().inject(this);
    }
}
