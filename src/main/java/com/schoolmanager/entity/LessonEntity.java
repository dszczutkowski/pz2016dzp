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
    private long teacherid;
    private String sbjct;
    private String classroom;
    private String dayofweek;
    private Time hours;
    private String description;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "teacherid")
    public long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(long teacherid) {
        this.teacherid = teacherid;
    }

    @Basic
    @Column(name = "sbjct")
    public String getSbjct() {
        return sbjct;
    }

    public void setSbjct(String sbjct) {
        this.sbjct = sbjct;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LessonEntity that = (LessonEntity) o;

        if (id != that.id) return false;
        if (teacherid != that.teacherid) return false;
        if (sbjct != null ? !sbjct.equals(that.sbjct) : that.sbjct != null) return false;
        if (classroom != null ? !classroom.equals(that.classroom) : that.classroom != null) return false;
        if (dayofweek != null ? !dayofweek.equals(that.dayofweek) : that.dayofweek != null) return false;
        if (hours != null ? !hours.equals(that.hours) : that.hours != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (teacherid ^ (teacherid >>> 32));
        result = 31 * result + (sbjct != null ? sbjct.hashCode() : 0);
        result = 31 * result + (classroom != null ? classroom.hashCode() : 0);
        result = 31 * result + (dayofweek != null ? dayofweek.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
