package com.dev.rairet.interwquest.business;

import com.dev.rairet.interwquest.data.db.entities.Theme;
import com.dev.rairet.interwquest.repositories.ThemesRepository;

import java.util.List;

import io.reactivex.Single;

public class ThemesInteractor {

    private ThemesRepository themesRepository;

    public ThemesInteractor(ThemesRepository themesRepository) {
        this.themesRepository = themesRepository;
    }

    public Single<List<Theme>> getAllThemes() {
        return themesRepository.getAllThemes();
    }
}
