package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.ac.rhul.cs2810.restaurantsystem.repository.MenuRepository;

@Controller
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    //value is the address of the page and
    // Get request method is an indicator that we are trying to get data from the database
    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public String findAll(Model model) {

        // List<Menu> menu = menuRepository.findAll();
        // 1st param: name of the data model that will be available to the UI
        // 2nd param:the data you want to pass (the list).
        //      gets all the rows of data from the menu table in the database and place it into a list.
        model.addAttribute("items", menuRepository.findAll());

        //the name of the html web page on which to display the data
        // after running the application enter in browser "http://localhost:8080/menu" to view the page
        return "index";
    }
}
