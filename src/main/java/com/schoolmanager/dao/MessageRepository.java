/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.schoolmanager.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import com.schoolmanager.entity.Message;
import com.schoolmanager.entity.Message_;

@ApplicationScoped
public class MessageRepository {

    @Inject
    private EntityManager em;

    public Message findById(Long id) {
        return em.find(Message.class, id);
    }

    public List<Message> findAllReceived(Long receiverId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Message> criteria = cb.createQuery(Message.class);
        Root<Message> message = criteria.from(Message.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.email), email));
        criteria.select(message).where(cb.equal(message.get(Message_.receiver), receiverId));
        return em.createQuery(criteria).getResultList();
    }

    public List<Message> findAllSent(Long senderId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Message> criteria = cb.createQuery(Message.class);
        Root<Message> message = criteria.from(Message.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.email), email));
        criteria.select(message).where(cb.equal(message.get(Message_.sender), senderId));
        return em.createQuery(criteria).getResultList();
    }

}
