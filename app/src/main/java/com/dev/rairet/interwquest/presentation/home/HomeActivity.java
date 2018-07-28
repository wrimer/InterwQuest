package com.dev.rairet.interwquest.presentation.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.dev.rairet.interwquest.R;
import com.dev.rairet.interwquest.data.db.entities.Theme;
import com.dev.rairet.interwquest.presentation.base.BaseActivity;
import com.dev.rairet.interwquest.presentation.base.BasePresenter;

import java.util.List;

public class HomeActivity extends BaseActivity implements HomeView {

    private RecyclerView rvThemes;
    private ThemesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        render();
    }

    private void render() {
        enableToolbar(R.layout.toolbar_preset_home)
                .setBackgroundColor(R.color.blue)
                .addBurgerButton(v -> openSideMenu());

        rvThemes = findViewById(R.id.rvThemes);
        rvThemes.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ThemesAdapter(theme -> presenter.onThemeClick(theme));
        rvThemes.setAdapter(adapter);
    }

    @Override
    public void showThemes(List<Theme> themes) {
        adapter.setItems(themes);
    }

    //==============================================================================================
    // *** Presenter ***
    //==============================================================================================
    @InjectPresenter
    HomePresenter presenter;

    public BasePresenter getPresenter() {
        return presenter;
    }
}
