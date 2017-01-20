package com.schoolmanager.view.model;


import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Model
@ManagedBean
@ViewScoped
public class ModelTest {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;

}
