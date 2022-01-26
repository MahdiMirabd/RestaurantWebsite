package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.rhul.cs2810.restaurantsystem.repository.MenuRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

@Controller
@RequestMapping(value = {"/order"})
public class OrderController {
    @Autowired
    private MenuRepository menuRepository;
    @GetMapping(value = {""})
    public String findAll(Model model) {

        model.addAttribute("items", menuRepository.findAll());
        return "order";
    }
}