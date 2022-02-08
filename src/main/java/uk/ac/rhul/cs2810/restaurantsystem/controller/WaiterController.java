package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.AlertRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WaiterController {
    @Autowired
    private OrderRepository orderRepository;
    private AlertRepository alertRepository;

    @RequestMapping(value = "/waiter", method = RequestMethod.GET)
    @GetMapping(value = {""})
    public String findAllOrders(Model model) {
        model.addAttribute("pendingOrders", orderRepository.findOrders("pending"));
        model.addAttribute("confirmedOrders", orderRepository.findOrders("confirmed"));
        return "waiter";
    }

    @RequestMapping(value = "/waiter/{id}" , method = {RequestMethod.GET, RequestMethod.PUT})
    public String confirmOrder(@PathVariable long id, Model model){
        Order order = orderRepository.getById(id);
        order.setStatus("confirmed");
        orderRepository.save(order);
        return findAllOrders(model);
    }

@GetMapping(value={""})
public String findAll(Model model) {
    model.addAttribute("Message", alertRepository.findAll());
    return "Message";
}

}