package com.dev.rairet.interwquest.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dev.rairet.interwquest.data.db.dao.ThemeDao;
import com.dev.rairet.interwquest.data.db.entities.Theme;

@Database(entities = {Theme.class}, version = 2)
public abstract class InterwQuestDb extends RoomDatabase {
    public abstract ThemeDao themeDao();
}
