package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.NotificationRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

/**
 * Queries the backend for data to be displayed on the waiter page.
 *
 */
@Controller
@RequestMapping(value = {"/ordertrack"})
public class OrderTrackController {
    @GetMapping(value = {""})
    public ModelAndView ordertrack() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ordertrack");
        return modelAndView;
    }
    // @Autowired
    // private OrderRepository orderRepository;
    // @RequestMapping(value = "/ordertrack", method = RequestMethod.GET)
    // public String findAll(Model model) {
    //     model.addAttribute("pendingOrders", orderRepository.findOrders("pending"));
    //     model.addAttribute("confirmedOrders", orderRepository.findOrders("confirmed"));
    //     model.addAttribute("readyOrders", orderRepository.findOrders("ready"));
    //     return "waiter";
    // }
    // @RequestMapping(value = "/ordertrack/{id}" , method = {RequestMethod.GET, RequestMethod.PUT})
    // public RedirectView confirmOrder(@PathVariable long id, Model model){
    //     Order order = orderRepository.getById(id);
    //     order.setStatus("confirmed");
    //     orderRepository.save(order);
    //     return new RedirectView("/ordertrack");
    // }

    // @RequestMapping(value = "/ordertrack/{id}" , method = {RequestMethod.GET, RequestMethod.PUT})
    // public RedirectView deliverOrder(@PathVariable long id, Model model){
    //     Order order = orderRepository.getById(id);
    //     order.setStatus("delivered");
    //     orderRepository.save(order);
    //     return new RedirectView("/ordertrack");
    // }
}