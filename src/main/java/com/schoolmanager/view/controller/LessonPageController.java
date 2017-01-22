package com.schoolmanager.view.controller;

import com.schoolmanager.dao.LessonRepository;
import com.schoolmanager.dao.MemberRepository;
import com.schoolmanager.entity.LessonEntity;
import com.schoolmanager.util.stereotypes.Controller;
import com.schoolmanager.view.model.LessonPageModel;
import com.schoolmanager.view.model.ModelTest;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class LessonPageController {

    @Inject
    private LessonPageModel lessonPageModel;

    @Inject
    private Logger log;

    @Inject
    private LessonRepository lessonRepository;

    @PostConstruct
    public void init(){

        log.info("HUEHUEUHEUHUEHUEHUEUHUEHUH \n");
        List<LessonEntity> list = lessonRepository.findAllOrderedBySubject();
        List<LessonEntity> poniedzialek = new ArrayList<LessonEntity>();
        List<LessonEntity> wtorek = new ArrayList<LessonEntity>();
        List<LessonEntity> sroda = new ArrayList<LessonEntity>();
        List<LessonEntity> czwartek = new ArrayList<LessonEntity>();
        List<LessonEntity> piatek = new ArrayList<LessonEntity>();
        List<ModelTest> lista  = new ArrayList<ModelTest>();
        for (LessonEntity lesson : list) {
            String dzien = lesson.getDayofweek();
            if (dzien.equals("poniedzialek")){
                log.info("dupa");
                poniedzialek.add(lesson);
                ModelTest hue = new ModelTest();
                hue.setDescription("HAHAHAHHAHADZIALAJKURWO");
                lista.add(hue);
            }
            if (dzien.equals("wtorek")){
                wtorek.add(lesson);
            }
            if (dzien.equals("sroda")){
                sroda.add(lesson);
            }
            if (dzien.equals("czwartek")){
                czwartek.add(lesson);
            }
            if (dzien.equals("piatek")){
                piatek.add(lesson);

            }
        }
        log.info("poniedzialek? " + poniedzialek.size());

        lessonPageModel.setLessons(lista);
        //lessonPageModel.setChosenKlasa("1a");
    }
    /*    for (LessonEntity lesson : list){
            if(lesson.getDayofweek().equals("poniedzialek")) {
                poniedzialek.add(lesson);
            }
            if(lesson.getDayofweek().equals("wtorek")) {
                wtorek.add(lesson);
            }
            if(lesson.getDayofweek().equals("sroda")) {
                sroda.add(lesson);
            }
            if(lesson.getDayofweek().equals("czwartek")) {
                czwartek.add(lesson);
            }
            if(lesson.getDayofweek().equals("piatek")) {
                piatek.add(lesson);
                log.info("piatek: " + lesson.getDayofweek() + "      " + lesson.getSubject());
            }
        }*/

    public void CheckIt() {
        log.info("UEUEUUEUEUEUUEUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUEEEE");
    }
}
