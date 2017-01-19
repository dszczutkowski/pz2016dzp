package com.schoolmanager.view.controller;

import com.schoolmanager.entity.Message;
import com.schoolmanager.service.LoginSession;
import com.schoolmanager.service.MemberRegistration;
import com.schoolmanager.service.MessageSender;
import com.schoolmanager.entity.Member;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * Created by Acer on 2016-12-05.
 */

@Model
public class MessagePageController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private MessageSender messageSender;

    @Inject
    private Logger log;

    @Produces
    @Named
    private Message newMessage;

    @PostConstruct
    public void initNewMessage() {
        newMessage = new Message();
    }


    public void init()
    {
        HttpSession session = LoginSession.getSession();
        Member meh;
        meh = (Member)session.getAttribute("USERNAME");
        log.info("aaaaaaaaaaaaaaaaaaaaaaaaaaa ->"+meh.getLogin());

    }

    public void send() throws Exception {
        try {
            newMessage.setText("dwdsdqd");
            messageSender.send(newMessage);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Wyslano!", "Wysylanie powiodlo sie");
            facesContext.addMessage(null, m);
            initNewMessage();
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Wysylanie nie powiodlo sie");
            facesContext.addMessage(null, m);
        }
    }

    private String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        String errorMessage = "Registration failed. See server log for more information";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }
}
