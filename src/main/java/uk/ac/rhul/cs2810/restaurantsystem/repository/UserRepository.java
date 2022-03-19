package uk.ac.rhul.cs2810.restaurantsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;
import uk.ac.rhul.cs2810.restaurantsystem.model.User;

/**
 * Provides the means for storing, retrieving,
 * searching, updating and deleting user credentials in the database.
 *
 * User - the model name
 * Long - the primary key of the table
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
