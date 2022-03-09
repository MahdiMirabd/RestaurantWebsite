package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Queries the backend for data to be displayed on the login page.
 *
 */
@Controller

public class LoginController {

    /**
     * Gets and displays the content of login.html.
     *
     * @return the login web page
     */
    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }*/
}