package com.schoolmanager.view.model;

import javax.enterprise.inject.Model;

@Model
public class IndexPageModel {
    public String getProszeDzialaj() {
        return proszeDzialaj;
    }

    public void setProszeDzialaj(String proszeDzialaj) {
        this.proszeDzialaj = proszeDzialaj;
    }

    private String proszeDzialaj;


}
