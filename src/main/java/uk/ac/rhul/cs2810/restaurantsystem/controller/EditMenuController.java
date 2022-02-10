package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Queries the backend for data to be displayed on the editMenu page.
 *
 */
@Controller
@RequestMapping(value = {"/editMenu"})
public class EditMenuController {

    /**
     * Gets and displays the content of editMenu.html.
     *
     * @return the editMenu web page
     */
    @GetMapping(value = {""})
    public ModelAndView editMenu() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editMenu");
        return modelAndView;
    }
}