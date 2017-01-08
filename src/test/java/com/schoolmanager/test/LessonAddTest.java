package com.schoolmanager.test;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import com.schoolmanager.entity.Lesson;
import com.schoolmanager.util.Resources;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

public class LessonAddTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(Lesson.class, Resources.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml");
    }
    @Inject
    Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Lesson> lessonEventSrc;

    @Test
    public void testRegister() throws Exception {
        Lesson newLesson = new Lesson();
        log.info("Registering " + newLesson.getLesson());
        em.persist(newLesson);
        lessonEventSrc.fire(newLesson);
        assertNotNull(newLesson.getId());
        log.info(newLesson.getLesson() + " was persisted with id " + newLesson.getId());
    }
}
