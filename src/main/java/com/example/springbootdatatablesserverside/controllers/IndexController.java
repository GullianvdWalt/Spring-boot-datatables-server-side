package com.example.springbootdatatablesserverside.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Gullian Van Der Walt
 * Created at 08:41 on Sep, 2021
 */
@Controller
public class IndexController {
    @GetMapping(value = {"/"})
    public ModelAndView getHome(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
}
