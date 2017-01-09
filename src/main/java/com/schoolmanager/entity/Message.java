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
@XmlRootElement
@Table(name = "MESSAGE")
public class Message {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @NotNull
    @NotEmpty
    @Column
    private String text;

    @NotNull
    @Column
    private Long senderId;

    @NotNull
    @Column
    private Long receiverId;
}
