package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
/**
 * Queries the backend for data to be displayed on orderTrack.html
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
}