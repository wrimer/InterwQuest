package com.dev.rairet.interwquest.presentation.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpView;
import com.dev.rairet.interwquest.R;
import com.dev.rairet.interwquest.presentation.base.toolbar.ToolbarBuilder;

public abstract class BaseActivity extends MvpAppCompatActivity implements MvpView {

    public abstract BasePresenter getPresenter();

    //@formatter:off
    protected CoordinatorLayout coordinatorLayout;
    public RelativeLayout uiRoot;
    //@formatter:on

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(R.layout.activity_base);

        ViewGroup uiContainer = findViewById(R.id.uiContainer);
        LayoutInflater.from(this).inflate(layoutResID, uiContainer, true);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        uiRoot = findViewById(R.id.uiRoot);

        initToolBar();
        initSideMenu();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            Log.i("loggs", "finish screen: " + this.getClass().getSimpleName());
        }
    }

    //==============================================================================================
    // *** Toolbar ***
    //==============================================================================================
    protected AppBarLayout appBarLayout;
    protected View vwToolbarShadow;

    protected Toolbar toolbar;
    protected ToolbarBuilder toolbarBuilder;
    private boolean useShadow = true;

    private void initToolBar() {
        appBarLayout = findViewById(R.id.appBarLayout);
        vwToolbarShadow = findViewById(R.id.vwToolbarShadow);
    }

    /**
     * <br>Настройка тулбара. Сначала верстается layout либо include-ся готовый.
     * <p>В макетах могут находиться View с Id, которые потом используются в чейн-методах.
     * <p>
     * <p><br>Например: Кладем в макет ImageView c R.id.toolbarBtnExample
     * <br>используя этот id можно установить кастомный обработчик:
     * <p>addCustomListener(R.id.toolbarBtnExample, (v) -> { to do.. })
     * <p>
     * <br><br>Либо воспользоваться одним из заготовленных методов, например:
     * <p>addBackButton()
     * <p>
     * <br><br>Примечание: такие методы используют Хардкодные Id.
     * <br>В описании (Ctrl+Q) заготовленных методов указано какой id они используют.
     * <br>Все заготовленные методы можно найти в {@link ToolbarBuilder}
     *
     * @param toolbarV7LayoutResID ид макета.
     */
    protected ToolbarBuilder enableToolbar(@LayoutRes int toolbarV7LayoutResID) {
        return enableToolbar(toolbarV7LayoutResID, false);
    }

    /**
     * Используйте этот метод, если корневой элемент CollapsingToolbarLayout.
     */
    protected ToolbarBuilder enableToolbar(@LayoutRes int toolbarV7LayoutResID, boolean wrappedInCollapse) {
        if (wrappedInCollapse) {
            LayoutInflater.from(this).inflate(toolbarV7LayoutResID, appBarLayout, true);
            toolbar = appBarLayout.findViewById(R.id.toolbar);
        } else {
            toolbar = (Toolbar) LayoutInflater.from(this).inflate(toolbarV7LayoutResID, appBarLayout, false);
            appBarLayout.addView(toolbar, 0);
        }

        toolbar.setContentInsetsAbsolute(0, 0);
        toolbarBuilder = new ToolbarBuilder(this, toolbar);
        showToolbar();

        return toolbarBuilder;
    }

    /**
     * Вернет Null если до этого не вызывался {@link #enableToolbar(int)}
     */
    @Nullable
    public ToolbarBuilder getToolbarBuilder() {
        return toolbarBuilder;
    }

    protected void hideToolbarShadow() {
        useShadow = false;
        vwToolbarShadow.setVisibility(View.GONE);
    }

    protected void showToolbarShadow() {
        useShadow = true;
        vwToolbarShadow.setVisibility(View.VISIBLE);
    }

    protected void hideToolbar() {
        if (toolbar != null) {
            appBarLayout.setVisibility(View.VISIBLE);
            vwToolbarShadow.setVisibility(View.GONE);
        }
    }

    protected void showToolbar() {
        if (toolbar != null) {
            appBarLayout.setVisibility(View.VISIBLE);
            if (useShadow) {
                vwToolbarShadow.setVisibility(View.VISIBLE);
            } else {
                vwToolbarShadow.setVisibility(View.GONE);
            }
        }
    }

    //==============================================================================================
    // *** Side menu ***
    //==============================================================================================
    private void initSideMenu() {

        DrawerLayout drawer = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.action_cancel, R.string.action_ok);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            Log.i("logger", "side menu");
            return true;
        });
    }

    public void openSideMenu(){
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        drawerLayout.openDrawer(Gravity.START);
    }
}