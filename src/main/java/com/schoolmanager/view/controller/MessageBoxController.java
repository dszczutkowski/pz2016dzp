package com.schoolmanager.view.controller;

import com.schoolmanager.entity.Member;
import com.schoolmanager.entity.Message;
import com.schoolmanager.service.LoginSession;
import com.schoolmanager.service.MessageSender;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Acer on 2017-01-18.
 */
@Model
public class MessageBoxController {
    @Inject
    private FacesContext facesContext;

    @Inject
    private Logger log;

    public void init()
    {
        HttpSession session = LoginSession.getSession();
        Member m;
        m = (Member)session.getAttribute("USERNAME");
    }



}
