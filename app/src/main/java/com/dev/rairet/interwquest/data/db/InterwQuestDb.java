package com.dev.rairet.interwquest.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dev.rairet.interwquest.data.db.dao.QuestionDao;
import com.dev.rairet.interwquest.data.db.dao.ThemeDao;
import com.dev.rairet.interwquest.data.db.entities.Question;
import com.dev.rairet.interwquest.data.db.entities.Theme;

@Database(entities = {Theme.class, Question.class}, version = 2)
public abstract class InterwQuestDb extends RoomDatabase {
    public abstract ThemeDao themeDao();
    public abstract QuestionDao questionDao();
}
