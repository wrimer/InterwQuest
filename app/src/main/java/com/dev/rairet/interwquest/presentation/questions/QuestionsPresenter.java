package com.dev.rairet.interwquest.presentation.questions;

import com.arellomobile.mvp.InjectViewState;
import com.dev.rairet.interwquest.App;
import com.dev.rairet.interwquest.Configuration;
import com.dev.rairet.interwquest.business.QuestionInteractor;
import com.dev.rairet.interwquest.data.db.entities.Question;
import com.dev.rairet.interwquest.data.db.entities.Theme;
import com.dev.rairet.interwquest.data.storage.MemoryStorage;
import com.dev.rairet.interwquest.presentation.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class QuestionsPresenter extends BasePresenter<QuestionsView> {

    @Inject
    QuestionInteractor questionInteractor;
    @Inject
    MemoryStorage memoryStorage;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getQuestionsList();
    }

    private void getQuestionsList() {
        Theme theme = (Theme) memoryStorage.getAndClear(Configuration.THEME_KEY);
        obsContainer.add(questionInteractor.getQuestionsById(theme.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    getViewState().setQuestionsList(response);
                }));
    }


    public void onRecyclerScroll(Question item, int position) {
        obsContainer.add(questionInteractor.getThemeById(item.getThemeId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    getViewState().updateToolbarInfo(response,position);
                }));
    }

    public void onAnswerClick(Theme item) {
    }

    public QuestionsPresenter() {
        App.getComponent().activityComponent().inject(this);
    }
}
