package com.schoolmanager.view.controller;

import com.schoolmanager.util.stereotypes.Controller;
import com.schoolmanager.view.model.IndexPageModel;

import javax.enterprise.inject.Model;


import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
/**
 * Created by Acer on 2017-01-16.
 */
@Controller
public class IndexPageController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private IndexPageModel indexPageModel;

    @Inject
    private Logger log;

    public void lessonButtonClick(){
        try {
            log.info("ccccccccccccccccccccccccc");
            FacesContext.getCurrentInstance().getExternalContext().redirect("lesson.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginButtonClick(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("loginPage.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerButtonClick(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("registration.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
