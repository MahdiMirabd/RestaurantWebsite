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

}