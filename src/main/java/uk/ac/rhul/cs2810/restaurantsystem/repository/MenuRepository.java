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
     * Finds all the menu items whose status is equal to true.
     *
     * @param status can be either true or false
     * @return menu items where the status field is true.
     */
    @Query("SELECT item FROM menu item WHERE item.available = :status")
    List<Menu> findItems(@Param("status") boolean status);

    @Transactional
    @Modifying
    @Query("UPDATE menu m SET m.available= false WHERE m.id = :id ")
    int updateMenuFalse(@Param("id") long id);

    @Transactional
    @Modifying
    @Query("UPDATE menu m SET m.available= true WHERE m.id = :id ")
    int updateMenuTrue(@Param("id") long id);

    @Transactional
    @Modifying
    @Query("SELECT item FROM menu item WHERE item.price > :itemMin AND item.price < :itemMax")
    List<Menu> findPriceRangeItems(@Param("itemMin") float itemMin, @Param("ItemMax") float itemMax);

    @Transactional
    @Modifying
    @Query("SELECT item FROM menu item WHERE item.calories > :itemMin AND item.calories < :itemMax")
    List<Menu> findCalorieRangeItems(@Param("itemMin") float itemMin, @Param("ItemMax") float itemMax);
