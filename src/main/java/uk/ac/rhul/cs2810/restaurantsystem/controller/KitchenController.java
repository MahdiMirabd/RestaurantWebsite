package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;
import uk.ac.rhul.cs2810.restaurantsystem.repository.NotificationRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.service.OrderService;

/**
 * Queries the backend for data to be displayed on the kitchen page.
 *
 */
@Controller
public class KitchenController {

    /**
     * An instance of the order repository.
     */
    @Autowired
    private OrderService orderService;

    @Autowired
    private NotificationRepository notificationRepository;

    /**
     * Finds all orders with confirmed status in the database.
     *
     * @param model the database table to be queried
     * @return a list of all confirmed orders in the database
     */
    @RequestMapping(value = "/kitchen", method = RequestMethod.GET)
    public String findConfirmedOrders(Model model) {
        model.addAttribute("orders", orderService.findOrderByStatus("confirmed"));
        return "kitchen";
    }

    /**
     * Changes the status of an order from confirmed to ready.
     *
     * @param id the order number
     * @param model the database table to query
     * @return the view back to the waiter page
     */
    @RequestMapping(value = "/kitchen/{id}" , method = {RequestMethod.GET, RequestMethod.PUT})
    public RedirectView changeStatus(@PathVariable long id, Model model){
        Order order = orderService.updateOrderStatus(id, "ready");
        notifyWaiters(id, order);
        return new RedirectView("/kitchen");
    }

    /**
     * Adds notification of delivery.
     *
     * @param id the order id
     * @param order the table on which to post the notification
     */
    @RequestMapping(value = "/notify" , method = RequestMethod.POST)
    public void notifyWaiters(Long id, Order order){
        Notification notification = new Notification();
        notification.setMessage("order is ready");
        notification.setTableNo((int) order.getTableNo());
        notificationRepository.save(notification);
    }

}