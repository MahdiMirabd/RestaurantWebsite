package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.ac.rhul.cs2810.restaurantsystem.service.MenuService;

/**
 * Queries the backend for data to be displayed on the editMenu page.
 *
 */
@Controller
public class EditMenuController {

    /**
     * An instance of the menu service.
     */
    @Autowired
    private MenuService menuService;

    /**
     * Gets and displays the content of editMenu.html.
     *
     * @param model - the database table being queried
     * @return the editMenu web page
     */
    @RequestMapping(value = "/editMenu", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("availableItems", menuService.findItems(true));
        model.addAttribute("unavailableItems", menuService.findItems(false));
        return "editMenu";
    }

    /**
     * Updates the availability of a selected menu item to false.
     *
     * @param id the menu item to be updated
     * @return to the edit menu base url.
     */
    @RequestMapping(value = "/editMenu/setFalse/{id}" , method = {RequestMethod.GET, RequestMethod.PUT})
    public RedirectView setUnavailable(@PathVariable long id){
        menuService.changeAvailability(id,false);
        return new RedirectView("/editMenu");
    }

    /**
     * Updates the availability of a selected menu item to true.
     *
     * @param id the menu item to be updated
     * @return to the edit menu base url.
     */
    @RequestMapping(value = "/editMenu/setTrue/{id}" , method = {RequestMethod.GET, RequestMethod.PUT})
    public RedirectView setAvailable(@PathVariable long id){
        menuService.changeAvailability(id,true);
        return new RedirectView("/editMenu");
    }
}