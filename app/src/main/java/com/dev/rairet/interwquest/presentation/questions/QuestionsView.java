package com.dev.rairet.interwquest.presentation.questions;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.dev.rairet.interwquest.data.db.entities.Question;
import com.dev.rairet.interwquest.data.db.entities.Theme;

import java.util.List;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface QuestionsView extends MvpView {

    void setQuestionsList(List<Question> response);

    void updateToolbarInfo(Theme theme, int position);
}
