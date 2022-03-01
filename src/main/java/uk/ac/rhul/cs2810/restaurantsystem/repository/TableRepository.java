package uk.ac.rhul.cs2810.restaurantsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.rhul.cs2810.restaurantsystem.model.Tables;

/**
 * Provides the means for storing, retrieving,
 * searching, updating and deleting Tables in the database.
 *
 * Tables - the model name
 * Long - the primary key of the table
 *
 */
@Repository
public interface TableRepository extends JpaRepository<Tables, Long> {

}
