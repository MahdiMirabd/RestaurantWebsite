package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Queries the backend for data to be displayed on the index page.
 *
 */
@Controller
@RequestMapping(value = {"/"})
public class IndexController {

    /**
     * Gets and displays the content of index.html.
     *
     * @return the home web page
     */
    @GetMapping(value = {""})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}