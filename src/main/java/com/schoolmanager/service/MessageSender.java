package com.schoolmanager.service;

import com.schoolmanager.entity.Member;
import com.schoolmanager.entity.Message;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by Acer on 2016-12-05.
 */
@Stateless
public class MessageSender {
    @Inject
    private EntityManager em;

    @Inject
    private Event<Message> memberEventSrc;

    public void send(Message message) throws Exception {
        em.persist(message);

        memberEventSrc.fire(message);
    }
}
