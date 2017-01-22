package com.schoolmanager.view.controller;

import com.schoolmanager.dao.MessageRepository;
import com.schoolmanager.entity.Member;
import com.schoolmanager.entity.Message;
import com.schoolmanager.service.LoginSession;
import com.schoolmanager.service.MessageSender;
import com.schoolmanager.util.stereotypes.Controller;
import com.schoolmanager.view.model.InboxPageModel;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Dawid on 2017-01-19.
 */
@Model
@ManagedBean
@ViewScoped
public class InboxController implements Serializable{

    @Inject
    private FacesContext facesContext;

    @Inject
    private Logger log;

    @Inject
    private InboxPageModel inboxPageModel;

    @Inject
    private MessageRepository messageRepository;



}
