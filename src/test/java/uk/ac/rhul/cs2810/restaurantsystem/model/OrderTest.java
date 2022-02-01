package uk.ac.rhul.cs2810.restaurantsystem.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private Order  order;

    @Test
    void testNullObjects() {
        order = new Order();
        assertNull(order.getName(), "No arguments passed to the constructor.");
    }

    @Test
    void testLombokAnnotations() {
        order = new Order();
        order.setName("Burrito");
        order.setPrice(20.5F);
        assertEquals(order.getPrice(), 20.5, "Could not get the item price.");
        assertNotNull(order.getName(), "Could not get the item name.");

    }
}
