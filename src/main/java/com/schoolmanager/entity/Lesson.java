package com.schoolmanager.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Acer on 2016-12-05.
 */

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(name = "LESSON")
public class Lesson {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String teacher;

    @NotNull
    @Column
    private String subject;

    @NotNull
    @Column
    private String classroom;

    @NotNull
    @Column
    private String dayOfWeek;

    @NotNull
    @Column
    private String time;

    @NotNull
    @Column
    private String klasa;
}

