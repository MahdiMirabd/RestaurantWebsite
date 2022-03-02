package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.rhul.cs2810.restaurantsystem.repository.TableRepository;

@Controller
public class PaymentController {

    @Autowired
    TableRepository tableRepository;

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String findByStatus(Model model) {
        model.addAttribute("tables", tableRepository.findByStatus(false));
        return "payment";
    }


}
