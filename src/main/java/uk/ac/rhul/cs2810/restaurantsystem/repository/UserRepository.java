package uk.ac.rhul.cs2810.restaurantsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
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

    /**
     * Gets a user with a specific username.
     *
     * @param username the username to lookup
     * @return a user with the matching username
     */
    @Query("SELECT user FROM users user WHERE user.username = :username")
    User findByUsername(@Param("username") String username);

    /**
     * Gets the password associated with a username.
     *
     * @param username the username to lookup
     * @return the password for a username
     */
    @Query("SELECT user.password FROM users user WHERE user.username = :username")
    String findUserPassword(@Param("username") String username);
}
