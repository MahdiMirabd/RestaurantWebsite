package uk.ac.rhul.cs2810.restaurantsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

import java.util.List;

/**
 * Interfaces with the Order Repository to fulfill
 * requests by the controller and return a response.
 */
@Service
public class OrderService {
    /**
     * An instance of the order repository.
     */
    @Autowired
    OrderRepository orderRepository;

    /**
     * Gets all order with a specified status,
     * An order status can be either: pending, confirmed,
     * ready, delivered or paid.
     *
     * @param status the specified status that an order must contain
     * @return a list of all orders with the specified status.
     */
    public List<Order> findOrderByStatus(String status) {
        return orderRepository.findOrderByStatus(status);
    }

    /**
     * Updates the status of an order to an new specified status
     *
     * @param id the order to be updated
     * @param status the new status to be applied to an order
     * @return the order which has been updated.
     */
    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepository.getById(id);
        order.setStatus(status);
        orderRepository.save(order);
        return order;
    }
}
