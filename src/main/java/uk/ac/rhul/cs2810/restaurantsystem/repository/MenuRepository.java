package uk.ac.rhul.cs2810.restaurantsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uk.ac.rhul.cs2810.restaurantsystem.model.Menu;

/**
 * Provides the means for storing, retrieving,
 * searching, updating and deleting menu items in the database.
 *
 * Menu - the model name.
 * Long - the primary key of the table.
 *
 * @author Hestre
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    /**
     * Finds all available menu items in the database table.
     *
     * @param status can be either true or false
     * @return menu items where the status field is true
     */
    @Query("SELECT item FROM menu item WHERE item.available = :status")
    List<Menu> findItems(@Param("status") boolean status);

    /**
     *Updates the availability of a selected menu item in the database table.
     *
     * @param id the menu item to be updated
     * @param availability a boolean value which can be True or False
     */
    @Transactional
    @Modifying
    @Query("UPDATE menu m SET m.available= :availability WHERE m.id = :id ")
    void changeAvailability(@Param("id") long id, @Param("availability") Boolean availability);
}
