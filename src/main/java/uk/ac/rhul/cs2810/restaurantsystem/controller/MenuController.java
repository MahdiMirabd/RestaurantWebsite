package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.ac.rhul.cs2810.restaurantsystem.repository.MenuRepository;

/**
 * Queries the repository for data in the menu table,
 * This data will be displayed on a webpage
 *
 * @author Hestre
 */
@Controller
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;

    /**
     * Retrieves the rows of data stored within the menu table.
     * value is the address of the page
     * Get request method is an indicator that we are trying to get data from the database
     *
     * @param model the database table being queried.
     * @return the html page on which to render the data
     */
    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public String findAll(Model model) {

        // 1st param: name of the data model that will be available to the UI.
        // use this name in the html file to access the data
        // 2nd param:the data you want to pass (the list).
        //      gets all the rows of data from the menu table in the database and place it into a list.
        model.addAttribute("items", menuRepository.findAll());

        // after running the application enter in browser "http://localhost:8080/menu" to view the page
        return "menu";
    }
}
