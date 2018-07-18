package com.dev.rairet.interwquest.presentation.base.toolbar;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rairet.interwquest.R;


public class ToolbarBuilder extends BaseToolbarBuilder<ToolbarBuilder> {

    public ToolbarBuilder(Context ctx, Toolbar toolbar) {
        this(ctx, toolbar, toolbar);
    }

    public ToolbarBuilder(Context ctx, Toolbar toolbar, View viewForSearch) {
        super(ctx, toolbar, viewForSearch);
    }

    /**
     * Кнопка домой
     */
    public ToolbarBuilder addBurgerButton(View.OnClickListener listener) {
        View view = findViewInToolbar(R.id.toolbarBtnBurger);
        view.setOnClickListener(listener);
        return this;
    }

    public ToolbarBuilder setBackgroundColor(@ColorRes int colorResId) {
        toolbar.setBackgroundResource(colorResId);
        return this;
    }

    public ToolbarBuilder setTopMargin(@DimenRes int dimenResId) {
        ((ViewGroup.MarginLayoutParams) toolbar.getLayoutParams()).topMargin = (int) ctx.getResources().getDimension(dimenResId);
        return this;
    }


    //==============================================================================================
    // *** insert Before | After ***
    //==============================================================================================
    public ToolbarBuilder insertAfter(@LayoutRes int layoutResID) {
        ViewGroup parent = (ViewGroup) toolbar.getParent();
        View view = LayoutInflater.from(ctx).inflate(layoutResID, parent, false);
        parent.addView(view, parent.getChildCount());
        return this;
    }

    public ToolbarBuilder insertBefore(@LayoutRes int layoutResID) {
        ViewGroup parent = (ViewGroup) toolbar.getParent();
        View view = LayoutInflater.from(ctx).inflate(layoutResID, parent, false);
        parent.addView(view, 0);
        return this;
    }

}
