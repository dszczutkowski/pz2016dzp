package com.schoolmanager.view.controller;

import com.schoolmanager.util.stereotypes.Controller;
import com.schoolmanager.view.model.LoginPageModel;
import com.schoolmanager.view.model.TimetablePageModel;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by Acer on 2016-11-28.
 */

@Controller
public class TimetablePageController {

    @Inject
    private TimetablePageModel timetablePageModel;


}
