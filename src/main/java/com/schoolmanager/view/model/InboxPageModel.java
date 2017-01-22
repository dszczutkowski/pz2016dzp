package com.schoolmanager.view.model;

import com.schoolmanager.entity.Member;
import com.schoolmanager.entity.Message;
import com.schoolmanager.service.LoginSession;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Dawid on 2017-01-19.
 */

@ManagedBean
@ViewScoped
@Model
public class InboxPageModel {

    private List<Message> messages;

    private Message selectedMessage;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Message getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(Message selectedMessage) {
        this.selectedMessage = selectedMessage;
    }
    @PostConstruct
    public void init()
    {
        HttpSession session = LoginSession.getSession();
        Member m;
        m = (Member)session.getAttribute("ID");
       // inboxPageModel.setMessages(messageRepository.findAllReceived(m.getId()));
    }
}
