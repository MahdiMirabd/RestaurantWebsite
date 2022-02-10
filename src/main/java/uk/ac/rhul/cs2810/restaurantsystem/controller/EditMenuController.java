package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.ac.rhul.cs2810.restaurantsystem.repository.MenuRepository;

/**
 * Queries the backend for data to be displayed on the editMenu page.
 *
 */
@Controller
public class EditMenuController {

    /**
     * Gets and displays the content of editMenu.html.
     *
     * @return the editMenu web page
     */
    @Autowired
    private MenuRepository menuRepository;
    
    @GetMapping(value = {""})
    public ModelAndView editMenu() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editMenu");
        return modelAndView;
    }

    @RequestMapping(value = "/editMenu", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("items", menuRepository.findAll());
        return "editMenu";
    }
}