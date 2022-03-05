package uk.ac.rhul.cs2810.restaurantsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.TableRepository;

@Controller
//@RequestMapping(value = {"/payment"})
public class PaymentController {
    @Autowired
    TableRepository tableRepository;

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String findByStatus(Model model) {
        model.addAttribute("tables", tableRepository.findByStatus(false));
        return "payment";
    }

   /* @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public ModelAndView payment() {
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("payment");
       return modelAndView;
    }*/

    /*@RequestMapping(value = "payment/total/{id}", method = RequestMethod.PUT)
    public RedirectView findOrderTotal(@PathVariable Long id, Model model) {
        System.out.println(id);
        return new RedirectView("/payment");
    }*/
    @RequestMapping(value = "payment/total", method = {RequestMethod.GET, RequestMethod.PUT})
    public RedirectView findOrderTotal(Model model, @ModelAttribute(value = "orders") Order order) {
        System.out.println(order.getId());
        return new RedirectView("/payment");
    }


}
