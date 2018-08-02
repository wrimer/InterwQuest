package com.dev.rairet.interwquest.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dev.rairet.interwquest.data.db.entities.Theme;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ThemeDao {

    @Query("SELECT * FROM theme")
    Single<List<Theme>> getAll();

    //==============================================================================================
    // *** debug ***
    //==============================================================================================

    @Query("SELECT * FROM theme")
    List<Theme> getAllDebug();
}
