package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.NotificationRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

/**
 * Queries the backend for data to be displayed on orderTrack.html
 *
 */
@Controller
@RequestMapping(value = {"/ordertrack"})
public class OrderTrackController {
    @GetMapping(value = {""})
    public ModelAndView ordertrack() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ordertrack");
        return modelAndView;
    }
}