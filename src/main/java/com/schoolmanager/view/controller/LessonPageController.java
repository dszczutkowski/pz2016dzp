package com.schoolmanager.view.controller;

import com.schoolmanager.dao.LessonRepository;
import com.schoolmanager.dao.MemberRepository;
import com.schoolmanager.entity.LessonEntity;
import com.schoolmanager.util.stereotypes.Controller;
import com.schoolmanager.view.model.Lekcje;
import com.schoolmanager.view.model.LessonPageModel;
import com.schoolmanager.view.model.ModelTest;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;

import java.util.*;
import java.util.logging.Logger;

@Controller
public class LessonPageController{

    @Inject
    private LessonPageModel lessonPageModel;

    @Inject
    private Logger log;

    @Inject
    private LessonRepository lessonRepository;

    @PostConstruct
    public void init(){
        List<LessonEntity> list = lessonRepository.findAllOrderedBySubject();
        List<Lekcje> lekcje = new ArrayList<Lekcje>();
        List<LessonEntity> poniedzialek = new ArrayList<LessonEntity>();
        List<LessonEntity> wtorek = new ArrayList<LessonEntity>();
        List<LessonEntity> sroda = new ArrayList<LessonEntity>();
        List<LessonEntity> czwartek = new ArrayList<LessonEntity>();
        List<LessonEntity> piatek = new ArrayList<LessonEntity>();

        for (LessonEntity lesson : list) {
            String dzien = lesson.getDayofweek();
            if (dzien.equals("poniedzialek")) {
                poniedzialek.add(lesson);
            }
            if (dzien.equals("wtorek")) {
                wtorek.add(lesson);
            }
            if (dzien.equals("sroda")) {
                sroda.add(lesson);
            }
            if (dzien.equals("czwartek")) {
                czwartek.add(lesson);
            }
            if (dzien.equals("piatek")) {
                piatek.add(lesson);
            }
        }
        int najwiekszy_size = poniedzialek.size();
        List<List<LessonEntity>> Tydzien = Arrays.asList(poniedzialek, wtorek,sroda,czwartek,piatek);
        najwiekszy_size = ZnajdzNajw(wtorek.size(), najwiekszy_size);
        najwiekszy_size = ZnajdzNajw(sroda.size(), najwiekszy_size);
        najwiekszy_size = ZnajdzNajw(czwartek.size(), najwiekszy_size);
        najwiekszy_size = ZnajdzNajw(piatek.size(), najwiekszy_size);
        for(List<LessonEntity> DzienZTygodnia: Tydzien)
        {
            int i = 0;
            while(DzienZTygodnia.size() < najwiekszy_size)
            {
                LessonEntity fake = new LessonEntity();
                fake.setSubject("BRAK");
                DzienZTygodnia.add(fake);
            }
            Tydzien.set(i, DzienZTygodnia);
            i++;
        }
        poniedzialek = Tydzien.get(0);
        wtorek = Tydzien.get(1);
        sroda = Tydzien.get(2);
        czwartek = Tydzien.get(3);
        piatek = Tydzien.get(4);

        for (int i = 0; i < najwiekszy_size; i++)
        {
             Lekcje row = new Lekcje();
             LessonEntity dzien = poniedzialek.get(i);
             row.setPoniedzialek(dzien.getSubject());
             dzien = wtorek.get(i);
             row.setWtorek(dzien.getSubject());
             dzien = sroda.get(i);
             row.setSroda(dzien.getSubject());
             dzien = czwartek.get(i);
             row.setCzwartek(dzien.getSubject());
             dzien = piatek.get(i);
             row.setPiatek(dzien.getSubject());
             lekcje.add(row);
        }
        lessonPageModel.setLekcje(lekcje);
        log.info("HUEHUEUHEUHUEHUEUHEUHUEHUEHUE: KLASA" + lessonPageModel.getChosenKlasa());
    }

    private int ZnajdzNajw(int size, int najwiekszy_size)
    {
        if(size > najwiekszy_size)
            return size;
        else
            return najwiekszy_size;
    }
    public void CheckIt() {
        log.info("UEUEUUEUEUEUUEUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUEEEE");
    }
}
