package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

@Controller
public class WaiterController {
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/waiter", method = RequestMethod.GET)
    @GetMapping(value = {""})
    public String findAllOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "waiter";
    }
}