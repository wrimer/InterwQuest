package com.dev.rairet.interwquest.presentation.base.toolbar;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.HashMap;

public class BaseToolbarBuilder<BuilderClass> {

    protected Context ctx;
    protected Toolbar toolbar;
    protected View viewForSearch;

    public BaseToolbarBuilder(Context ctx, Toolbar toolbar, View viewForSearch) {
        this.ctx = ctx;
        this.toolbar = toolbar;
        this.viewForSearch = viewForSearch;
        mapIdToViewHolder = new HashMap<>();
    }

    /**
     * Добавить обработчик нажатия.
     *
     * @param viewId   ид элемента. (Должен присутствовать в лейауте)
     * @param listener обработчик.
     */
    public BuilderClass addCustomListener(@IdRes int viewId, View.OnClickListener listener) {
        View view = findViewInToolbar(viewId);
        view.setOnClickListener(listener);
        return (BuilderClass) this;
    }

    public interface IScenario {
        void doCustomAction(Toolbar toolbar);
    }

    /**
     * Максимальная свобода действий. Используйте toolbar + findViewById для достижения ваших целей.
     *
     * @param scenario сценарий.
     */
    public BuilderClass customScenario(IScenario scenario) {
        scenario.doCustomAction(toolbar);
        return (BuilderClass) this;
    }


    //==============================================================================================
    // *** Utils ***
    //==============================================================================================
    private HashMap<Integer, View> mapIdToViewHolder;

    protected View findViewInToolbar(@IdRes int viewId) {
        View view = mapIdToViewHolder.get(viewId);
        if (view == null) {
            view = viewForSearch.findViewById(viewId);
            mapIdToViewHolder.put(viewId, view);
            return view;
        }

        return view;
    }

    public interface ViewModifier {
        void modify(View view);
    }

}
