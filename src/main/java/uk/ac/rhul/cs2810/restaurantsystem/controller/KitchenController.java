package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

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
    private OrderRepository orderRepository;

    /**
     * Finds all orders with confirmed status in the database.
     *
     * @param model the database table to be queried
     * @return a list of all confirmed orders in the database
     */
    @RequestMapping(value = "/kitchen", method = RequestMethod.GET)
    @GetMapping(value = {""})
    public String findAllOrders(Model model) {
        model.addAttribute("orders", orderRepository.findOrders("confirmed"));
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
    public String confirmOrder(@PathVariable long id, Model model){
        Order order = orderRepository.getById(id);
        order.setStatus("ready");
        orderRepository.save(order);
        return findAll(model);
    }

}