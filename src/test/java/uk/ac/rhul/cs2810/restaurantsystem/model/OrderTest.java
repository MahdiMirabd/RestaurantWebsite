package uk.ac.rhul.cs2810.restaurantsystem.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import uk.ac.rhul.cs2810.restaurantsystem.repository.OrderRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
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
        order.setQuantity(2);
        assertEquals(order.getQuantity(), 2, "Could not get the item price.");
    }

    @Test
    void addOneOrder() {
        Order order = new Order();
        order.setTableNumber(1);
        order.setName("Nacho");
        order.setQuantity(2);
        order.setStatus("pending");

        Order savedOrder = orderRepository.save(order);
        assertTrue(savedOrder.getId() > 0);
    }
}
