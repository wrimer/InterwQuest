package com.dev.rairet.interwquest.presentation.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.dev.rairet.interwquest.R;
import com.dev.rairet.interwquest.data.db.entities.Theme;
import com.dev.rairet.interwquest.util.GlideApp;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

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

        private LinearLayout llItem;
        private ImageView ivThemeAvatar;
        private TextView tvThemeName;
        private TextView tvQuestionCount;


        ThemesViewHolder(@NonNull View itemView, Context context, OnThemeClickListener listener) {
            super(itemView);
            this.context = context;
            this.listener = listener;

            llItem = itemView.findViewById(R.id.llItem);
            ivThemeAvatar = itemView.findViewById(R.id.ivThemeAvatar);
            tvThemeName = itemView.findViewById(R.id.tvThemeName);
            tvQuestionCount = itemView.findViewById(R.id.tvQuestionCount);
        }

        void render(Theme model) {

            tvThemeName.setText(model.getThemeName());

            tvQuestionCount.setText(context.getResources().getQuantityString
                    (R.plurals.question_plurals, model.getQuestionCount(),model.getQuestionCount()));



            GlideApp.with(context)
                    .load(model.getImage())
                    .circleCrop()
                    .into(ivThemeAvatar);


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
