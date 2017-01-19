package com.schoolmanager.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import com.schoolmanager.entity.LessonEntity;

@ApplicationScoped
public class LessonRepository {
    @Inject
    private EntityManager em;

    public LessonEntity findById(Long id) {
        return em.find(LessonEntity.class, id);
    }

    public LessonEntity findByKlasa(String klasa) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LessonEntity> criteria = cb.createQuery(LessonEntity.class);
        Root<LessonEntity> lesson = criteria.from(LessonEntity.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(LessonEntity).where(cb.equal(LessonEntity.get(LessonEntity_.email), email));
        criteria.select(lesson).where(cb.equal(lesson.get("klasa"), klasa));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<LessonEntity> findAllOrderedBySubject() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LessonEntity> criteria = cb.createQuery(LessonEntity.class);
        Root<LessonEntity> lesson = criteria.from(LessonEntity.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(LessonEntity).orderBy(cb.asc(LessonEntity.get(LessonEntity_.name)));
        criteria.select(lesson); //.orderBy(cb.asc(LessonEntity.get("FIRSTNAME"))
        return em.createQuery(criteria).getResultList();
    }
}
