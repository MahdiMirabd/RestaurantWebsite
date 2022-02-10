package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/editMenu"})
public class EditMenuController {
    @GetMapping(value = {""})
    public ModelAndView editMenu() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editMenu");
        return modelAndView;
    }
}