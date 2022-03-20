package uk.ac.rhul.cs2810.restaurantsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.rhul.cs2810.restaurantsystem.model.Menu;
import uk.ac.rhul.cs2810.restaurantsystem.repository.MenuRepository;

import java.util.List;

/**
 * Interfaces with the Menu Repository to fulfill
 * requests by the controller and return a response.
 */
@Service
public class MenuService {
    /**
     * An instance of the menu repository.
     */
    @Autowired
    private MenuRepository menuRepository;

    /**
     * Gets all the menu items with a specified value,
     * in the "available" database field.
     *
     * @param availability a specified boolean value used to query the database
     * @return a list of all menu items which contains the specified value
     */
    public List<Menu> findItems(Boolean availability) {
        return menuRepository.findItems(availability);
    }

    /**
     * Updates the availability of a menu item to either true or false.
     *
     * @param id the menu item to update
     * @param availability a boolean value to be applied to the menu item
     */
    public void changeAvailability(Long id, Boolean availability) {
        menuRepository.changeAvailability(id, availability);
    }

    /**
     * Gets all menu items in the database.
     *
     * @return a list of all menu items
     */
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }
}
