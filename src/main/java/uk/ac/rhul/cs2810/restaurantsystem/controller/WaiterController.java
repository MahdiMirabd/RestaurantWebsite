package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.view.RedirectView;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.NotificationRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

/**
 * Queries the backend for data to be displayed on the waiter page.
 *
 */
@Controller
public class WaiterController {
    /**
     * An instance of the order repository.
     */
    @Autowired
    private OrderRepository orderRepository;

    /**
     * An instance of the alert repository.
     */
    @Autowired
    private NotificationRepository notificationRepository;

    /**
     * Queries the backend for all orders and alert notifications.
     *
     * @param model the database table to be queried
     * @return a list of all pending and confirmed orders as well as alerts in the database
     */
    @RequestMapping(value = "/waiter", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("pendingOrders", orderRepository.findOrders("pending"));
        model.addAttribute("confirmedOrders", orderRepository.findOrders("confirmed"));
        model.addAttribute("alert", notificationRepository.findAll());
        return "waiter";
    }

    /**
     * Changes the status of an order from pending to confirmed.
     *
     * @param id the order number
     * @param model the database table on which to post the order
     * @return the view back to the waiter page
     */
    @RequestMapping(value = "/waiter/{id}" , method = {RequestMethod.GET, RequestMethod.PUT})
    public String confirmOrder(@PathVariable long id, Model model){
        Order order = orderRepository.getById(id);
        order.setStatus("confirmed");
        orderRepository.save(order);
        return findAll(model);
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
        return new RedirectView("order");
    }

}