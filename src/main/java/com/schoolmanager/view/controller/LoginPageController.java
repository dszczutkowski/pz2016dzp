package com.schoolmanager.view.controller;

import com.schoolmanager.util.stereotypes.Controller;
import com.schoolmanager.view.model.LoginPageModel;
import org.slf4j.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;

@Controller
public class LoginPageController {

    @Inject
    private LoginPageModel loginPageModel;
    private Logger logger;

    public void login() {
        String login = loginPageModel.getLogin();
        String password = loginPageModel.getPassword();

        if(false){
            FacesMessage wrongLoginPasswordMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Wrong login/password","Wrong login/password");
            FacesContext.getCurrentInstance().addMessage(null,wrongLoginPasswordMsg);
        }

        else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("timetable.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void register() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("registration.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
