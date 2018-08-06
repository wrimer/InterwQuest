package com.dev.rairet.interwquest.business;

import com.dev.rairet.interwquest.data.db.entities.Question;
import com.dev.rairet.interwquest.data.db.entities.Theme;
import com.dev.rairet.interwquest.repositories.QuestionRepository;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class QuestionInteractor {

    private QuestionRepository questionRepository;

    public QuestionInteractor(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Single<List<Question>> getQuestionsById(long id) {
        return questionRepository.getQustionsById(id);
    }

    public Single<Theme> getThemeById(long themeId) {
        return questionRepository.getThemeById(themeId);
    }
}
