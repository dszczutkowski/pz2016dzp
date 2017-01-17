package com.schoolmanager.view.controller;

import com.schoolmanager.util.stereotypes.Controller;
import com.schoolmanager.view.model.LessonPageModel;


import javax.inject.Inject;
import java.io.IOException;

import java.util.logging.Logger;

@Controller
public class LessonPageController {

    @Inject
    private LessonPageModel LessonPageModel;

    @Inject
    private Logger log;

    public void CheckIt() {
        log.info("UEUEUUEUEUEUUEUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUEEEE");
    }

}
