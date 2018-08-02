package com.dev.rairet.interwquest.presentation.questions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rairet.interwquest.R;
import com.dev.rairet.interwquest.data.db.entities.Question;
import com.dev.rairet.interwquest.data.db.entities.Theme;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder> {

    private List<Question> items = new ArrayList<>();
    private QuestionsAdapter.OnAnswerClickListener listener;

    public QuestionsAdapter(OnAnswerClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.li_question, parent, false);
        return new QuestionsViewHolder(v, parent.getContext(), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, int position) {
        holder.render(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Question> questions) {
        items = questions;
        notifyDataSetChanged();
    }

    //==============================================================================================
    // *** View Holder ***
    //==============================================================================================
    public static class QuestionsViewHolder extends RecyclerView.ViewHolder {

        private Context context;

        QuestionsViewHolder(@NonNull View itemView, Context context, OnAnswerClickListener listener) {
            super(itemView);
            this.context = context;
        }

        void render(Question model) {

        }
    }

    //==============================================================================================
    // *** Listeners ***
    //==============================================================================================
    interface OnAnswerClickListener {

        void onAnswerClick(Theme theme);
    }
}