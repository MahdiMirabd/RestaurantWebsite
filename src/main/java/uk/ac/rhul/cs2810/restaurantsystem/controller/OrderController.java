package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.MenuRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

@Controller
//@RequestMapping(value = {"/order"})
public class OrderController {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private OrderRepository orderRepository;

    //@GetMapping(value = {""})
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String findAll(Model model) {

        model.addAttribute("items", menuRepository.findAll());
        return "order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String submitOrder(Model model, @ModelAttribute(value = "orders") Order orders) {
       Order order = orderRepository.save(orders);
       return "Order";
    }
}