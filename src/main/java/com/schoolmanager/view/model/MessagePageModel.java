package com.schoolmanager.view.model;

import javax.enterprise.inject.Model;

/**
 * Created by Acer on 2016-12-05.
 */
@Model
public class MessagePageModel {

    private String messageText;

    private String topic;


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

}
