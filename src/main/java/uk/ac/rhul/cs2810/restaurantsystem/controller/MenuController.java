package uk.ac.rhul.cs2810.restaurantsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.ac.rhul.cs2810.restaurantsystem.service.MenuService;

/**
 * Delegates its functionality to the service layer and returns the
 * result of the computation to the view.
 * This data will be displayed on the menu.html page.
 *
 * @author Hestre
 */
@Controller
public class MenuController {
    /**
     * An instance of the menuService class.
     */
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
