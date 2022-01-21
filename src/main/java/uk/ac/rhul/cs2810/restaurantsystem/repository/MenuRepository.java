package uk.ac.rhul.cs2810.restaurantsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.rhul.cs2810.restaurantsystem.model.Menu;

/**
 * Provides the means for storing, retrieving,
 * searching, updating and deleting objects in the database.
 *
 * Menu - the model name.
 * Long - the primary key of the table
 *
 * @author Hestre
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
