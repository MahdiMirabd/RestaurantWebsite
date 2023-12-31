package uk.ac.rhul.cs2810.restaurantsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.model.Tables;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.TableRepository;

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

    @Autowired
    TableRepository tableRepository;

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
     * Deletes an order from the database.
     *
     * @param id the order to be removed
     */
    public void deleteOrder(Long id) {
        Order order = orderRepository.getById(id);
        orderRepository.delete(order);
    }

    /**
     * Adds a new order to the database.
     *
     * @param order the order to be added to the database table
     */
    public void addOrder(Order order) {
        Tables table = tableRepository.getById(order.getTableNo());
        order.setTable(table);
        orderRepository.save(order);
    }

    /**
     * Gets the sum of the orders submitted by a table number.
     *
     * @param tableNo the table number to lookup
     * @param status only sum orders with delivered status
     * @return a sum of the orders
     */
    public Float getTotalCost(Long tableNo, String status) {
        return orderRepository.getTotalCost(tableNo,status);
    }

    /**
     * Updates the status of an order to a specified value.
     *
     * @param tableNo the set of orders submitted by a table to be updated
     * @param status the value to be applied to the order
     */
    public void updateOrderStatus(Long tableNo, String status) {
        orderRepository.updateOrderStatus(tableNo, status);
    }

    /**
     * Gets an order by the id.
     *
     * @param id the order id to lookup
     * @return the order which satisfies the order id
     */
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    /**
     * Gets the status of a table and returns a message depending on the status
     *
     * @param table the table number
     * @return a message depending on the status of the order
     */
    public String getTableStatus(long table) {
        List<Order> orders = orderRepository.findStatusByTable(table);
        if (orders.size() > 0)  {
            String status = orders.get(0).getStatus();
            switch(status) {
                case "pending":
                    return "We got your order";
                case "confirmed":
                    return "Your order is being prepared";
                case "ready":
                    return "Your order is ready";
                case "delivered":
                    return "Your order is with you";
            }
            
        }
            return "";
    }
}
