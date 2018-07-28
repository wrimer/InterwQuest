package com.dev.rairet.interwquest.presentation.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.rairet.interwquest.R;
import com.dev.rairet.interwquest.data.db.entities.Theme;

import java.util.ArrayList;
import java.util.List;

public class ThemesAdapter extends RecyclerView.Adapter<ThemesAdapter.ThemesViewHolder> {

    private List<Theme> items = new ArrayList<>();
    private OnThemeClickListener listener;

    public ThemesAdapter(OnThemeClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ThemesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.li_theme, parent, false);
        return new ThemesViewHolder(v, parent.getContext(), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ThemesViewHolder holder, int position) {
        holder.render(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Theme> themes) {
        items = themes;
        notifyDataSetChanged();
    }

    //==============================================================================================
    // *** View Holder ***
    //==============================================================================================
    public static class ThemesViewHolder extends RecyclerView.ViewHolder {

        private Context context;
        private OnThemeClickListener listener;

        private TextView tvName;
        private TextView tvSecond;

        ThemesViewHolder(@NonNull View itemView, Context context, OnThemeClickListener listener) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvSecond = itemView.findViewById(R.id.tvSecond);
            this.context = context;
            this.listener = listener;
        }

        void render(Theme model) {
            tvName.setText(model.name);
            tvSecond.setText(String.valueOf(model.salary));
            itemView.setOnClickListener(view -> listener.onThemeClicked(model));
        }
    }

    //==============================================================================================
    // *** Listeners ***
    //==============================================================================================
    interface OnThemeClickListener {

        void onThemeClicked(Theme theme);
    }
}
