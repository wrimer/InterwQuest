package com.dev.rairet.interwquest.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.dev.rairet.interwquest.data.db.entities.Theme;

import java.util.List;

@Dao
public interface ThemeDao {

    @Query("SELECT * FROM theme")
    List<Theme> getAll();
}
