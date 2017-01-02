package com.schoolmanager.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
public class Lesson implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotEmpty
    private String lesson;

    @NotNull
    @NotEmpty
    private String teacher;

    @NotNull
    @NotEmpty
    private String klasa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLesson() {
        return lesson;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getKlasa() {
        return klasa;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

}
