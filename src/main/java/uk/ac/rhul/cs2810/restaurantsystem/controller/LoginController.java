package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import uk.ac.rhul.cs2810.restaurantsystem.model.User;
import uk.ac.rhul.cs2810.restaurantsystem.service.UserService;

/**
 * Renders the content of login.html on a webpage.
 *
 */
@Controller

public class LoginController {

    @Autowired
    UserService userService;

    /**
     * Displays the content of the login page on a webpage.
     *
     * @return the login page.
     */
    @RequestMapping(value = "/login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * Authenticates a user.
     *
     * @param user the user to be authenticated
     * @return redirects the user to an appropriate URL.
     */
    @RequestMapping(value = "/login/authenticate",  method = {RequestMethod.POST, RequestMethod.GET})
    public RedirectView login(@ModelAttribute(value = "users")User user) {
        System.out.println(user);
        System.out.println(userService.authenticate(user));
        if (!(userService.authenticate(user))) {
            return new RedirectView("/login");
        } else  {
            String role = userService.findUserRole(user);

            if (role.equals("WAITER")) {
                return new RedirectView("http://localhost:8080/waiter");
            }
                return new RedirectView("http://localhost:8080/kitchen");

        }
    }
}