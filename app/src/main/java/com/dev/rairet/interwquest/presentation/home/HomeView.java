package com.dev.rairet.interwquest.presentation.home;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.dev.rairet.interwquest.data.db.entities.Theme;

import java.util.List;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface HomeView extends MvpView {

    void showThemes(List<Theme> list);
}
