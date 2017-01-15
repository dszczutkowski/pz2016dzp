package com.schoolmanager.view.controller;

import com.schoolmanager.util.stereotypes.Controller;
import com.schoolmanager.view.model.LessonPageModel;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.IOException;

@Controller
public class LessonPageController {

    @Inject
    private LessonPageModel LessonPageModel;
    private Logger logger;

    public void CheckIt() {
        logger.debug("UEUEUUEUEUEUUEUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUEEEE");
    }

}
