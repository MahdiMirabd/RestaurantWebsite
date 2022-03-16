package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Renders the content of Index.html on a webpage.
 *
 */
@Controller
public class IndexController {

    /**
     * Gets and displays the content of index.html.
     *
     * @return the home web page
     */
    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}