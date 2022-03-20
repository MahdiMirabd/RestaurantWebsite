package uk.ac.rhul.cs2810.restaurantsystem.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uk.ac.rhul.cs2810.restaurantsystem.model.Tables;
import uk.ac.rhul.cs2810.restaurantsystem.repository.TableRepository;

/**
 * Populates specified database tables automatically.
 */
@Component
public class DatabaseInfo implements CommandLineRunner {
    @Autowired
    TableRepository tableRepository;

    @Override
    public void run(String... args) throws Exception {
        if(tableRepository.count() == 0) {
            insertTableRecords();
        }
    }

    /**
     * Inserts a list of tables into the database,
     * including its availability and assigned waiter.
     */
    public void insertTableRecords() {
        int [] waiters = {1, 2, 3};
        int j = 0;
        // insert 20 table records into the database
        for (int i = 0; i < 20 && j < waiters.length; i++) {
            Tables newTable = new Tables();
            newTable .setAvailable(true);
            newTable .setWaiter("waiter" + waiters[j]);
            tableRepository.save(newTable);

            // increment j if it is less than 2 else reset to 0
            j = (j == waiters.length - 1) ? 0 : j + 1;
        }
    }
}
