package uk.ac.rhul.cs2810.restaurantsystem.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;

    @Test
    void testNullObjects() {
        menu = new Menu();
       assertNull(menu.getName(), "No arguments passed to the constructor.");
    }

   @Test
    void testLombokAnnotations() {
        menu = new Menu();
        menu.setName("Burrito");
        menu.setPrice(20.5F);
        assertEquals(menu.getPrice(), 20.5, "Could not get the item price.");
        assertNotNull(menu.getName(), "Could not get the item name.");
    }
}