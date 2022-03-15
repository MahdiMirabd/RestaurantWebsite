package uk.ac.rhul.cs2810.restaurantsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import uk.ac.rhul.cs2810.restaurantsystem.repository.MenuRepository;
import uk.ac.rhul.cs2810.restaurantsystem.service.MenuService;

/**
 * Queries the repository for data in the menu table,
 * This data will be displayed on a webpage
 *
 * @author Hestre
 */
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

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
        model.addAttribute("items", menuService.findItems(true));
        return "menu";
    }
}
