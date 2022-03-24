package uk.ac.rhul.cs2810.restaurantsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
    /**
     * Find all tables in the database based on a status,
     * True or false.
     *
     * @param stat  can be true or false
     * @return A list of all the tables that satisfy the status
     */
    @Query("SELECT t FROM tables  t WHERE t.available = :stat")
    List<Tables> findByAvailability(@Param("stat") boolean stat);

    /**
     * Updates the availability of a table.
     *
     * @param available true or false
     * @param table The table to be updated
     */
    @Transactional
    @Modifying
    @Query("UPDATE tables t SET t.available= :available WHERE t.id = :table ")
    void changeTableAvailability(@Param("available") boolean available, @Param("table") Long table);
}
