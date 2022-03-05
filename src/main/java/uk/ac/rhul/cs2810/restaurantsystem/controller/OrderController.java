package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.view.RedirectView;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.MenuRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.NotificationRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;


/**
 * Queries the backend for data to be displayed on the order page.
 *
 */
@Controller
public class OrderController {

    /**
     * An instance of the menu repository.
     */
    @Autowired
    private MenuRepository menuRepository;

    /**
     * An instance of the order repository.
     */
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    /**
     * Finds all menu items with availability set to true.
     *
     * @param model the database table to query
     * @return a list of available menu items
     */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String findAvailableItems(Model model) {
        model.addAttribute("items", menuRepository.findItems(true));
        return "order";
    }

    /**
     * Posts a new customer order to the database.
     *
     * @param model the database table to query
     * @param orders the data to be posted
     * @return the order page
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String submitOrder(Model model, @ModelAttribute(value = "orders") Order orders) {
       Order order = orderRepository.save(orders);
       return "order";
    }

    /**
     * Submits a new customer request to the database.
     *
     * @param model the database table on which to post the request
     * @param message the data to be posted
     * @return the view back to the order page
     */
    @RequestMapping(value = "/help", method = RequestMethod.POST)
    public RedirectView submitAlert(Model model, @ModelAttribute(value = "messageTable") Notification message) {
        Notification notification = notificationRepository.save(message);
        return new RedirectView("/order");
    }


   

}