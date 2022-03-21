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
import uk.ac.rhul.cs2810.restaurantsystem.service.OrderService;

/**
 * Queries the backend for data to be displayed on the payment.html.
 *
 */
@Controller
public class PaymentController {

    /**
     * An instance of the order service.
     */
    @Autowired
    OrderService orderService;


    /**
     * Gets the total cost of orders submitted by a table.
     *
     * @param model the database table to be queried.
     * @param order the orders to be summed.
     */
    @RequestMapping(value = "/payment", method = {RequestMethod.GET, RequestMethod.PUT})
    public void getOrderTotal(Model model, @ModelAttribute(value = "orders") Order order) {
        Long tableNo = order.getId();
        Float totalPrice = orderService.getTotalCost(tableNo,"delivered");

        if (totalPrice != null) {
            model.addAttribute("total", "Total price is: " + totalPrice);
        } else {
            model.addAttribute("total", "There is no payment due.");
        }
        model.addAttribute("table", tableNo);
    }

    /**
     * Updates the status of a set of orders by a specified payment number to paid.
     *
     * @param order the orders to be updated
     * @return to the base URL
     */
    @RequestMapping(value = "payment/complete", method = {RequestMethod.GET, RequestMethod.PUT})
    public RedirectView completePayment(@ModelAttribute(value = "orders") Order order) {
        Long tableNo = order.getId();
        orderService.updateOrderStatus(tableNo, "paid");
        return new RedirectView("/payment");
    }
}
