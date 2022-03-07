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
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.TableRepository;

@Controller
//@RequestMapping(value = {"/payment"})
public class PaymentController {
    @Autowired
    TableRepository tableRepository;

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/payment", method = {RequestMethod.GET, RequestMethod.PUT})
    public void getOrderTotal(Model model, @ModelAttribute(value = "orders") Order order) {
        //model.addAttribute("tables", tableRepository.findByStatus(false));
        Long tableNo = order.getId();
        Float totalPrice = orderRepository.getTotalCost(tableNo,"delivered");
        if (totalPrice != null) {
            model.addAttribute("total", "Total price is: " + totalPrice);
        } else {
            model.addAttribute("total", "There is no payment due.");
        }
        model.addAttribute("table", tableNo);
    }

    @RequestMapping(value = "payment/complete", method = {RequestMethod.GET, RequestMethod.PUT})
    public RedirectView completePayment(Model model, @ModelAttribute(value = "orders") Order order) {
        Long tableNo = order.getId();
        orderRepository.updateOrderStatus(tableNo, "paid");
        return new RedirectView("/payment");
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
    /*@RequestMapping(value = "payment/total", method = {RequestMethod.GET, RequestMethod.PUT})
    public RedirectView findOrderTotal(Model model, @ModelAttribute(value = "orders") Order order) {
        Long tableNo = order.getId();
        model.addAttribute("total", orderRepository.getTotalCost(tableNo));
        System.out.println(orderRepository.getTotalCost(tableNo));
        return new RedirectView("/payment");
    }*/


}
