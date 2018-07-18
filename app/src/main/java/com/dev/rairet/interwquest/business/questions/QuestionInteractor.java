package com.dev.rairet.interwquest.business.questions;

import com.dev.rairet.interwquest.repositories.questions.QuestionRepository;

public class QuestionInteractor {

    private QuestionRepository questionRepository;

    public QuestionInteractor(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
}
