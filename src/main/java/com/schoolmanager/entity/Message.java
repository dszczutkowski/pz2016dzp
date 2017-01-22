package com.schoolmanager.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Date;

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

    public Member getReceiver() {
        return receiver;
    }

    public void setReceiver(Member receiver) {
        this.receiver = receiver;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_receiver")
    private Member receiver;

    public Member getSender() {
        return sender;
    }

    public void setSender(Member sender) {
        this.sender = sender;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_sender")
    private Member sender;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Column
    private LocalDateTime date;

    public String getTopic() { return topic; }

    public void setTopic(String topic) { this.topic = topic; }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}