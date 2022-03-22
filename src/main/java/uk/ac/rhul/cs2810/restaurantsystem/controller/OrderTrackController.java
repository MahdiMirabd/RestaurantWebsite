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
import uk.ac.rhul.cs2810.restaurantsystem.service.OrderService;

/**
 * Queries the backend for data to be displayed on orderTrack.html
 *
 */
@Controller
public class OrderTrackController {
    
    /**
     * An instance of the order service.
     */
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/ordertrack", method = RequestMethod.GET)
    public ModelAndView ordertrack() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ordertrack");
        return modelAndView;
    }
    @RequestMapping(value = "/ordertrack/getStatus", method = RequestMethod.GET)
    public RedirectView getStatus(Model model, @ModelAttribute(value = "table") long table) {
        model.addAttribute("table", orderService.getTableStatus(table));
        return new RedirectView("/ordertrack");
    }
}