package com.dev.rairet.interwquest.business;

import com.dev.rairet.interwquest.repositories.QuestionRepository;

public class QuestionInteractor {

    private QuestionRepository questionRepository;

    public QuestionInteractor(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
}
