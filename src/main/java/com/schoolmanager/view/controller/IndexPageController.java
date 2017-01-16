package com.schoolmanager.view.controller;

import com.schoolmanager.util.stereotypes.Controller;
import com.schoolmanager.view.model.IndexPageModel;
import com.schoolmanager.view.model.LoginPageModel;
import org.slf4j.Logger;

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
    private IndexPageModel indexPageModel;
    private Logger logger;

    public void lessonButtonClick(){
        try {
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
