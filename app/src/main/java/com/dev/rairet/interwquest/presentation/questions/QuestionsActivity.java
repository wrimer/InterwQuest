package com.dev.rairet.interwquest.presentation.questions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.dev.rairet.interwquest.R;
import com.dev.rairet.interwquest.data.db.entities.Question;
import com.dev.rairet.interwquest.data.db.entities.Theme;
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
        enableToolbar(R.layout.toolbar_preset_question)
                .setBackgroundColor(R.color.colorPrimaryDark)
                .addBackButton(v -> finish());

        rvQuestions = findViewById(R.id.rvQuestions);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        SnapHelper snapHelper = new PagerSnapHelper();

        adapter = new QuestionsAdapter(item -> presenter.onAnswerClick(item));
        rvQuestions.setLayoutManager(linearLayoutManager);
        rvQuestions.setAdapter(adapter);
        snapHelper.attachToRecyclerView(rvQuestions);

        rvQuestions.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                presenter.onRecyclerScroll(adapter.getItemByPosition(linearLayoutManager.findFirstVisibleItemPosition()),
                        linearLayoutManager.findFirstVisibleItemPosition());
            }
        });

    }

    @Override
    public void setQuestionsList(List<Question> questions) {
        adapter.setItems(questions);
    }

    @Override
    public void updateToolbarInfo(Theme theme, int position) {
        toolbarBuilder.setToolbarCountText(String.format(getResources().getString(R.string.question_count),
                position + 1, adapter.getItemCount()));
        toolbarBuilder.setToolbarTitleText(theme.getThemeName());

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
