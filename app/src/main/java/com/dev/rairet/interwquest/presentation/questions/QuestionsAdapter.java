package com.dev.rairet.interwquest.presentation.questions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.rairet.interwquest.R;
import com.dev.rairet.interwquest.data.db.entities.Question;
import com.dev.rairet.interwquest.data.db.entities.Theme;
import com.dev.rairet.interwquest.util.HtmlImageGetter;
import com.dev.rairet.interwquest.util.HtmlTagHandler;

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
        holder.render(items.get(position), position, items.size());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Question> questions) {
        items = questions;
        notifyDataSetChanged();
    }

    public Question getItemByPosition(int position) {
        return items.get(position);
    }

    //==============================================================================================
    // *** View Holder ***
    //==============================================================================================
    public static class QuestionsViewHolder extends RecyclerView.ViewHolder {

        private Context context;
        private TextView tvQuestion;
        private TextView tvAnswer;
        private TextView tvCopyrights;
        private OnAnswerClickListener listener;

        QuestionsViewHolder(@NonNull View itemView, Context context, OnAnswerClickListener listener) {
            super(itemView);
            this.context = context;

            tvQuestion = itemView.findViewById(R.id.tvQuestion);
            tvAnswer = itemView.findViewById(R.id.tvAnswer);
            tvCopyrights = itemView.findViewById(R.id.tvCopyrights);
            this.listener = listener;
        }

        void render(Question model, int position, int itemsSize) {
            tvQuestion.setText(Html.fromHtml(model.getQuestion()));
            tvAnswer.setText(Html.fromHtml(model.getAnswer(), new HtmlImageGetter(context), new HtmlTagHandler()));
            tvCopyrights.setText(Html.fromHtml(model.getCopyrights()));
            tvCopyrights.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    //==============================================================================================
    // *** Listeners ***
    //==============================================================================================
    interface OnAnswerClickListener {

        void onAnswerClick(Theme theme);
    }
}
