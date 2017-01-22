package com.schoolmanager.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Acer on 2016-12-05.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "MESSAGE")
public class Message {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String topic;

    @Column
    private String text;

    @Column
    private Long senderId;

    @Column
    private Long receiverId;


    public String getTopic() { return topic; }

    public void setTopic(String topic) { this.topic = topic; }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }



}
