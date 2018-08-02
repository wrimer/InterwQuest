package com.dev.rairet.interwquest.presentation.questions;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.dev.rairet.interwquest.R;
import com.dev.rairet.interwquest.data.db.entities.Question;
import com.dev.rairet.interwquest.presentation.base.BaseActivity;
import com.dev.rairet.interwquest.presentation.base.BasePresenter;

import java.util.List;

public class QuestionsActivity extends BaseActivity implements QuestionsView {

    private RecyclerView rvQuestions;
    private QuestionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        BaseActivity.disableSideMenu();

        render();

    }

    private void render() {
        rvQuestions = findViewById(R.id.rvQuestions);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        SnapHelper snapHelper = new PagerSnapHelper();

        rvQuestions.setLayoutManager(linearLayoutManager);
        adapter = new QuestionsAdapter(item -> presenter.onQuestionClick(item));
        rvQuestions.setAdapter(adapter);
        snapHelper.attachToRecyclerView(rvQuestions);
    }

    @Override
    public void showQuestions(List<Question> questions) {
        adapter.setItems(questions);
    }

    //==============================================================================================
    // *** Presenter ***
    //==============================================================================================
    @InjectPresenter
    QuestionsPresenter presenter;

    public BasePresenter getPresenter() {
        return presenter;
    }
}
