package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.service.NotificationService;
import uk.ac.rhul.cs2810.restaurantsystem.service.OrderService;

/**
 * Queries the backend for data to be displayed on the waiter.html.
 *
 */
@Controller
public class WaiterController {
    /**
     * An instance of the order repository.
     */
    @Autowired
    private OrderService orderService;

    /**
     * An instance of the notification service.
     */
    @Autowired
    private NotificationService notificationService;

    /**
     * Queries the backend for all orders and alert notifications.
     *
     * @param model the database table to be queried
     * @return a list of all pending and confirmed orders as well as alerts in the database
     */
    @RequestMapping(value = "/waiter", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("pendingOrders", orderService.findOrderByStatus("pending"));
        model.addAttribute("confirmedOrders", orderService.findOrderByStatus("confirmed"));
        model.addAttribute("readyOrders", orderService.findOrderByStatus("ready"));
        model.addAttribute("deliveredOrders", orderService.findOrderByStatus("delivered"));
        model.addAttribute("alert", notificationService.findAll());
        model.addAttribute("alertCount", notificationService.getTotalNotifications());
        return "waiter";
    }

    /**
     * Changes the status of an order from pending to confirmed.
     *
     * @param id the order number
     * @return the view back to the waiter page
     */
    @RequestMapping(value = "/waiter/confirmOrder/{id}" , method = {RequestMethod.GET, RequestMethod.PUT})
    public RedirectView confirmOrder(@PathVariable long id) {
        Order order = orderService.getById(id);
        orderService.updateOrderStatus(order.getTableNo(), "confirmed");
        return new RedirectView("/waiter");
    }

    /**
     * Updates an order in the database to delivered.
     *
     * @param id the order to be updated
     * @return to the base URL
     */
    @RequestMapping(value = "/waiter/deliverOrder/{id}" , method = {RequestMethod.GET, RequestMethod.PUT})
    public RedirectView deliverOrder(@PathVariable long id) {
        Order order = orderService.getById(id);
        orderService.updateOrderStatus(order.getTableNo(), "delivered");
        return new RedirectView("/waiter");
    }

    /**
     * Deletes a notification from the database.
     *
     * @param id the notification to be deleted
     * @return to the base URL
     */
    @RequestMapping(value = "/waiter/deleteNotification/{id}" , method = {RequestMethod.GET, RequestMethod.DELETE})
    public RedirectView deleteNotifications(@PathVariable long id) {
        notificationService.deleteNotification(id);
        return new RedirectView("/waiter");
    }

    /**
     * Deletes an order from the database.
     *
     * @param id the order to be deleted
     * @return to the base URL
     */
    @RequestMapping(value = "/waiter/cancelOrder/{id}" , method = {RequestMethod.GET, RequestMethod.DELETE})
    public RedirectView deleteOrder(@PathVariable long id) {
        orderService.deleteOrder(id);
        return new RedirectView("/waiter");
    }
}