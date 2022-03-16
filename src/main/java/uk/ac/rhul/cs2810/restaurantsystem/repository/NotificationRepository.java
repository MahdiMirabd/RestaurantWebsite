package uk.ac.rhul.cs2810.restaurantsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;

/**
 * Provides the means for storing, retrieving,
 * searching, updating and deleting alerts in the database.
 *
 * Notification - the model name
 * Long - the primary key of the table
 *
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
