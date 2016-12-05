package com.schoolmanager.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Acer on 2016-12-05.
 */

@SuppressWarnings("serial")
@Entity
@XmlRootElement
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotEmpty
    private String text;

    @NotNull
    private Long senderId;

    @NotNull
    private Long receiverId;
}
