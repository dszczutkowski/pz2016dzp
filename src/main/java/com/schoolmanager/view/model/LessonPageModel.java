package com.schoolmanager.view.model;

import javax.enterprise.inject.Model;

@Model
public class LessonPageModel {
    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    private String klasa;
}
