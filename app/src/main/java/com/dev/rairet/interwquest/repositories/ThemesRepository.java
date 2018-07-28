package com.dev.rairet.interwquest.repositories;

import com.dev.rairet.interwquest.data.db.InterwQuestDb;
import com.dev.rairet.interwquest.data.db.entities.Theme;

import java.util.List;

import io.reactivex.Single;

public class ThemesRepository {
    private InterwQuestDb database;

    public ThemesRepository(InterwQuestDb db) {
        database = db;
    }

    public Single<List<Theme>> getAllThemes() {
        return database.themeDao().getAll();
    }
}
