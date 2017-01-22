package com.schoolmanager.view.model;

import com.schoolmanager.entity.LessonEntity;

import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Model
@ManagedBean
@ViewScoped
public class LessonPageModel {
    private List<ModelTest> lessons = new ArrayList<ModelTest>();

    public List<ModelTest> getLessons() {
        return lessons;
    }

    public void setLessons(List<ModelTest> lessons) {
        this.lessons = lessons;
    }

    public String getChosenKlasa() {
        return chosenKlasa;
    }

    public void setChosenKlasa(String chosenKlasa) {
        this.chosenKlasa = chosenKlasa;
    }

    public List<String> getKlasy() {
        return Klasy;
    }

    public void setKlasy(List<String> klasy) {
        Klasy = klasy;
    }

    private List<String> Klasy = Arrays.asList("1a", "1b", "1c");;

    private String chosenKlasa;
}
