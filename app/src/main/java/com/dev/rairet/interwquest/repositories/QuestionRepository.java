package com.dev.rairet.interwquest.repositories;

import com.dev.rairet.interwquest.data.db.InterwQuestDb;
import com.dev.rairet.interwquest.data.db.entities.Question;
import com.dev.rairet.interwquest.data.db.entities.Theme;

import java.util.List;

import io.reactivex.Single;

public class QuestionRepository {
    private InterwQuestDb database;

    public QuestionRepository(InterwQuestDb db) {
        database = db;
    }

    public Single<List<Question>> getQustionsById(long id) {
        return database.questionDao().getQuestionsByTheme(id);
    }

    public Single<Theme> getThemeById(long themeId) {
        return database.themeDao().getThemeById(themeId);
    }
}
