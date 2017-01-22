package com.schoolmanager.view.model;


import com.schoolmanager.dao.LessonRepository;
import com.schoolmanager.entity.LessonEntity;

import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
@ManagedBean
@ViewScoped
@SessionScoped
public class Lekcje implements Serializable {

    static public List<Lekcje> createLekcje() {
        List<Lekcje> lista = new ArrayList<Lekcje>();
        for (int i = 0; i < 10; i++) {
            Lekcje lekcja = new Lekcje();
            lekcja.poniedzialek = "matma";
            lekcja.wtorek = "polak";
            lekcja.sroda = "angielski";
            lekcja.czwartek = "infa";
            lekcja.piatek = "heheszki";
            lista.add(lekcja);
        }
        return lista;
    }

    public String getPoniedzialek() {
        return poniedzialek;
    }

    public void setPoniedzialek(String poniedzialek) {
        this.poniedzialek = poniedzialek;
    }

    public String getWtorek() {
        return wtorek;
    }

    public void setWtorek(String wtorek) {
        this.wtorek = wtorek;
    }

    public String getSroda() {
        return sroda;
    }

    public void setSroda(String sroda) {
        this.sroda = sroda;
    }

    public String getCzwartek() {
        return czwartek;
    }

    public void setCzwartek(String czwartek) {
        this.czwartek = czwartek;
    }

    public String getPiatek() {
        return piatek;
    }

    public void setPiatek(String piatek) {
        this.piatek = piatek;
    }

    private String poniedzialek;
    private String wtorek;
    private String sroda;
    private String czwartek;
    private String piatek;
}
