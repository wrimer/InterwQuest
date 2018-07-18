package com.dev.rairet.interwquest.presentation.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.dev.rairet.interwquest.R;
import com.dev.rairet.interwquest.presentation.base.BaseActivity;
import com.dev.rairet.interwquest.presentation.base.BasePresenter;

public class HomeActivity extends BaseActivity implements HomeView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        render();
    }

    private void render() {

        enableToolbar(R.layout.toolbar_preset_home)
                .setBackgroundColor(R.color.blue)
                .addBurgerButton(v -> {
                    openSideMenu();
                });


        Log.i("sdf","sdf");
        TextView textView = findViewById(R.id.tvHome);
        textView.setOnClickListener(view -> {

        });
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
