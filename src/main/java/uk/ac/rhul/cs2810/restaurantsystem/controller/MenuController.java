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
     * value is the address of the page.
     * Get request method is an indicator that we are trying to get data from the database.
     *
     * @param model the database table being queried
     * @return the html page on which to render the data
     */
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String findAvailableItems(Model model) {
        model.addAttribute("items", menuRepository.findItems(true));
        return "menu";
    }
}
