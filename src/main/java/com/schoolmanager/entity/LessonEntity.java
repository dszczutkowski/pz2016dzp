package com.schoolmanager.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Acer on 2017-01-04.
 */
@Entity
@Table(name = "lesson", schema = "schoolmanager", catalog = "")
public class LessonEntity {
    private long id;
    private String teacher;
    private String subject;
    private String classroom;
    private String dayofweek;
    private Time hours;
    private String description;
    private String klasa;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "teacher")
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String sbjct) {
        this.subject = sbjct;
    }

    @Basic
    @Column(name = "classroom")
    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Basic
    @Column(name = "dayofweek")
    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }

    @Basic
    @Column(name = "hours")
    public Time getHours() {
        return hours;
    }

    public void setHours(Time hours) {
        this.hours = hours;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "klasa")
    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LessonEntity that = (LessonEntity) o;

        if (id != that.id) return false;
        if (teacher != that.teacher) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (classroom != null ? !classroom.equals(that.classroom) : that.classroom != null) return false;
        if (dayofweek != null ? !dayofweek.equals(that.dayofweek) : that.dayofweek != null) return false;
        if (hours != null ? !hours.equals(that.hours) : that.hours != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (klasa != null ? !klasa.equals(that.klasa) : that.klasa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (classroom != null ? classroom.hashCode() : 0);
        result = 31 * result + (dayofweek != null ? dayofweek.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (klasa != null ? klasa.hashCode() : 0);
        return result;
    }
}
