package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/waiter"})
public class WaiterController {
    @GetMapping(value = {""})
    public ModelAndView waiter() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("waiter");
        return modelAndView;
    }
}