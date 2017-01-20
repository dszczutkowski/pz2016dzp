package com.schoolmanager.dao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import com.schoolmanager.entity.LessonEntity;

@RequestScoped
public class LessonListProducer {

    @Inject
    private LessonRepository lessonRepository;

    private List<LessonEntity> lessons;

    // @Named provides access the return value via the EL variable name "members" in the UI (e.g.
    // Facelets or JSP view)
    @Produces
    @Named
    public List<LessonEntity> getLessons() {
        return lessons;
    }

    public void onLessonListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final LessonEntity lesson) {
        retrieveAllLessonsOrderedBySubject();
    }

    @PostConstruct
    public void retrieveAllLessonsOrderedBySubject() {
        lessons = lessonRepository.findAllOrderedBySubject();
    }
}
