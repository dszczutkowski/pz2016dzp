package com.schoolmanager.view.model;

import com.schoolmanager.entity.Member;
import com.schoolmanager.service.LoginSession;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpSession;

@Model
public class IndexPageModel {

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }

    private String loggedUser;


    @PostConstruct
    public void init() {
        HttpSession session = LoginSession.getSession();
        Member m = (Member) session.getAttribute("USERNAME");
        setLoggedUser(m.getLogin());
    }
}
