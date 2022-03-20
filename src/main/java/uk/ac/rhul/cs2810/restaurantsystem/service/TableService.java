package uk.ac.rhul.cs2810.restaurantsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.rhul.cs2810.restaurantsystem.model.Tables;
import uk.ac.rhul.cs2810.restaurantsystem.repository.TableRepository;

import java.util.List;

@Service
public class TableService {
    /**
     * An instance of the table repository.
     */
    @Autowired
    TableRepository tableRepository;

    /**
     * Gets all of the tables with a specified availability value.
     *
     * @param available a boolean value
     * @return a list of all the tables that satisfies the boolean value
     */
    public List<Tables> findAvailableTable(Boolean available) {
        return tableRepository.findByAvailability(available);
    }

    /**
     * Changes the availability of a table.
     *
     * @param available a boolean value
     * @param table the table number to be updated with the boolean value
     */
    public void changeTableAvailability(boolean available, Long table) {
        tableRepository.changeTableAvailability(available, table);
    }
}
