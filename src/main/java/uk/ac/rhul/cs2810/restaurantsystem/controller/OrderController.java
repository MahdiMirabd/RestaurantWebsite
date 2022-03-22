package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.view.RedirectView;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.service.MenuService;
import uk.ac.rhul.cs2810.restaurantsystem.service.NotificationService;
import uk.ac.rhul.cs2810.restaurantsystem.service.OrderService;
import uk.ac.rhul.cs2810.restaurantsystem.service.TableService;


/**
 * Queries the backend for data to be displayed on the order page.
 *
 */
@Controller
public class OrderController {

    /**
     * An instance of the menu service.
     */
    @Autowired
    private MenuService menuService;

    /**
     * An instance of the order service.
     */
    @Autowired
    private OrderService orderService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TableService tableService;

    /**
     * Finds all menu items with availability set to true.
     *
     * @param model the database table to query
     * @return a list of available menu items
     */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String findAvailableItems(Model model) {
        model.addAttribute("items", menuService.findItems(true));
        model.addAttribute("tables", tableService.findAll());
        return "order";
    }

    /**
     * Posts a new customer order to the database.
     *
     * @param orders the data to be posted
     * @return the order page
     */
    @RequestMapping(value = "/order/addOrder", method = RequestMethod.POST)
    public String submitOrder(@ModelAttribute(value = "orders") Order orders) {
        orderService.addOrder(orders);
        return "order";
    }

    /**
     * Submits a new customer request to the database.
     *
     * @param message the data to be posted
     * @return the view back to the order page
     */
    @RequestMapping(value = "/order/clientHelp", method = RequestMethod.POST)
    public RedirectView submitAlert(@ModelAttribute(value = "notification") Notification message) {
        notificationService.addClientRequest(message);
        return new RedirectView("/order");
    }
}