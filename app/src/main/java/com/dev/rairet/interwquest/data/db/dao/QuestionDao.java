package com.dev.rairet.interwquest.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.dev.rairet.interwquest.data.db.entities.Question;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface QuestionDao {

    @Query("SELECT * FROM question")
    Single<List<Question>> getAll();

    @Query("SELECT * FROM question WHERE themeId=:themeId")
    Single<List<Question>> getQuestionsByTheme(final long themeId);
}

