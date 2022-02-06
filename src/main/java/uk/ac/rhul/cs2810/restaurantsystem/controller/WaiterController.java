package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

import java.util.Optional;

@Controller
public class WaiterController {
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/waiter", method = RequestMethod.GET)
    @GetMapping(value = {""})
    public String findAllOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "waiter";
    }

    @RequestMapping(value = "/waiter/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public void confirmOrder(@PathVariable("id") long id, Model model){
        Order order = orderRepository.findById(id).get();
        order.setStatus("confirmed");
        orderRepository.save(order);
        System.out.println("saved the changes");
    }

}