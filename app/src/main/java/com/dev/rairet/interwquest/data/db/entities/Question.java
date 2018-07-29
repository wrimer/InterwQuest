package com.dev.rairet.interwquest.data.db.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Theme.class,
        parentColumns = "id",
        childColumns = "themeId"))
public class Question {

    @PrimaryKey
    private long id;
    private long themeId;
    private String question;
    private String answer;
    private String copyrights;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getThemeId() {
        return themeId;
    }

    public void setThemeId(long themeId) {
        this.themeId = themeId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }
}
