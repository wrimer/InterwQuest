package com.dev.rairet.interwquest.data.db.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Theme {

    @PrimaryKey
    public long id;

    public String name;

    public int salary;
}
