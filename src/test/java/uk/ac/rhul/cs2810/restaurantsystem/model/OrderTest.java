package uk.ac.rhul.cs2810.restaurantsystem.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private Order  order;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testNullObjects() {
        order = new Order();
        assertNull(order.getStatus(), "No arguments passed to the constructor.");
    }

    @Test
    void testLombokAnnotations() {
        order = new Order();
        order.setPrice(20.5F);
        assertEquals(order.getPrice(), 20.5, "Could not get the item price.");
    }
}
