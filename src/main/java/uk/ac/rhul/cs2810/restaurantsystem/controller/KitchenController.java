package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.view.RedirectView;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.service.NotificationService;
import uk.ac.rhul.cs2810.restaurantsystem.service.OrderService;
import uk.ac.rhul.cs2810.restaurantsystem.service.UserService;

/**
 * Queries the backend for data to be displayed on the kitchen page.
 *
 */
@Controller
public class KitchenController {

    /**
     * An instance of the order service.
     */
    @Autowired
    private OrderService orderService;

    /**
     * An instance of the notification service.
     */
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    /**
     * Finds all orders with confirmed status in the database.
     *
     * @param model the database table to be queried
     * @return a list of all confirmed orders in the database
     */
    @RequestMapping(value = "/kitchen", method = RequestMethod.GET)
    public void findConfirmedOrders(Model model) {
        // can only view the content of this page by logging in as a kitchen staff.
        if (userService.getPermissions().equals("kitchen")) {
            model.addAttribute("orders", orderService.findOrderByStatus("confirmed"));
        }
    }

    /**
     * Updates the status of an order from confirmed to ready,
     * and notifies the waiters when the order is ready.
     *
     * @param id the order number
     * @return the view back to the waiter page
     */
    @RequestMapping(value = "/kitchen/orderReady/{id}" , method = {RequestMethod.GET, RequestMethod.PUT})
    public RedirectView changeStatus(@PathVariable long id) {
        Order order = orderService.getById(id);
        orderService.updateOrderStatus(order.getTableNo(), "ready");
        notificationService.insertNotification("order is ready", order);
        return new RedirectView("/kitchen");
    }
}