package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.view.RedirectView;
import uk.ac.rhul.cs2810.restaurantsystem.model.Alert;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.AlertRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;


@Controller
public class WaiterController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AlertRepository alertRepository;

    @RequestMapping(value = "/waiter", method = RequestMethod.GET)
    public String findAllOrders(Model model) {
        model.addAttribute("pendingOrders", orderRepository.findOrders("pending"));
        model.addAttribute("confirmedOrders", orderRepository.findOrders("confirmed"));
        model.addAttribute("alert", alertRepository.findAll());
        return "waiter";
    }

    @RequestMapping(value = "/waiter/{id}" , method = {RequestMethod.GET, RequestMethod.PUT})
    public String confirmOrder(@PathVariable long id, Model model){
        Order order = orderRepository.getById(id);
        order.setStatus("confirmed");
        orderRepository.save(order);
        return findAllOrders(model);
    }

    @RequestMapping(value = "/help", method = RequestMethod.POST)
    public RedirectView submitOrder(Model model, @ModelAttribute(value = "messageTable") Alert message) {
        Alert alert = alertRepository.save(message);
        return new RedirectView("order");
    }

}