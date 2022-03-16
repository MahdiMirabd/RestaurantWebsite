package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Renders the content of login.html on a webpage.
 *
 */
@Controller

public class LoginController {

    /**
     * Gets and displays the content of login.html.
     *
     * @return the login web page
     */
    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}