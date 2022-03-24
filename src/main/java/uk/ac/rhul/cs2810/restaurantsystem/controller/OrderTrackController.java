package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.model.Tables;
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
    /**
     * Finds the status of an order given a table
     *
     * @param model the database table 
     * @param table table number
     */
    @RequestMapping(value = "/ordertrack", method = {RequestMethod.GET, RequestMethod.POST})
    public void getStatus(Model model, @ModelAttribute(value = "table") Tables table) {
        model.addAttribute("table", orderService.getTableStatus(table.getId()));
    }
}