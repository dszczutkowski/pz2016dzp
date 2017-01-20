package com.schoolmanager.view.controller;

import com.schoolmanager.dao.MemberRepository;
import com.schoolmanager.entity.Member;
import com.schoolmanager.util.stereotypes.Controller;
import com.schoolmanager.view.model.LoginPageModel;
import com.schoolmanager.service.LoginSession;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginPageController {

    @Inject
    private LoginPageModel loginPageModel;

    @Inject
    private FacesContext facesContext;

    @Inject
    private java.util.logging.Logger log;

    @Inject
    private MemberRepository memberRepository;

    public void login() {
        String login = loginPageModel.getLogin();
        String password = loginPageModel.getPassword();
        long id = 0;
        Member loggedMember = new Member();
        List<Member> list = memberRepository.findAllOrderedByName();
        for(Member m : list) {
            if(m.getLogin().equals(login) && m.getPassword().equals(password)) {
                id = m.getId();
                loggedMember = m;
            }
        }
        if(id == 0){
            FacesMessage wrongLoginPasswordMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Wrong login/password","Wrong login/password");
            FacesContext.getCurrentInstance().addMessage(null,wrongLoginPasswordMsg);
        }
        else
            try {
                HttpSession session = LoginSession.getSession();
                session.setAttribute("USERNAME", loggedMember);
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                log.info("Zalogowano uzytkownika - id: " + id + " login: " + loggedMember.getLogin());
                FacesMessage loggedInMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Logged in as " + loggedMember.getLogin(),"Logged in as " + loggedMember.getLogin());
                FacesContext.getCurrentInstance().addMessage(null,loggedInMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void register() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("registration.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        try {
            HttpSession session = LoginSession.getSession();
            session.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("loginPage.xhtml");
            log.info("Wylogowano!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
