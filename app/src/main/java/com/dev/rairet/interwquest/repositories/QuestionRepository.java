package com.dev.rairet.interwquest.repositories;

import com.dev.rairet.interwquest.data.db.InterwQuestDb;

public class QuestionRepository {
    private InterwQuestDb database;

    public QuestionRepository(InterwQuestDb db) {
        database = db;
    }
}
