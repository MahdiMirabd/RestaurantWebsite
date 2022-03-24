package uk.ac.rhul.cs2810.restaurantsystem.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uk.ac.rhul.cs2810.restaurantsystem.model.Menu;
import uk.ac.rhul.cs2810.restaurantsystem.model.Tables;
import uk.ac.rhul.cs2810.restaurantsystem.model.User;
import uk.ac.rhul.cs2810.restaurantsystem.repository.MenuRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.TableRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.UserRepository;

/**
 * Populates specified database tables automatically.
 */
@Component
public class DatabaseInfo implements CommandLineRunner {
    /**
     * An instance of the table repository.
     */
    @Autowired
    TableRepository tableRepository;

    /**
     * An instance of the menu repository.
     */
    @Autowired
    MenuRepository menuRepository;

    /**
     * An instance of the user repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Executes commands on the command line.
     *
     * @param args the commands to be run
     * @throws Exception if the commands cannot be executed
     */
    @Override
    public void run(String... args) throws Exception {
        if(tableRepository.count() == 0) {
            insertTableRecords();
        }
        if(menuRepository.count() == 0) {
            insertMenuItems();
        }

        if(userRepository.count() == 0) {
            insertUserRecords();
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

    /**
     * Insert Menu items into the database.
     */
    public void insertMenuItems() {
        Menu burrito = new Menu(1,"Burrito",20.5f, 90, "beef, cheese and spicy rice, beans",
                "Gluten, Milk, Celery, Soy", "/img/burrito.jpg", true );
        Menu nacho = new Menu(2, "Nacho", 10.5f, 100, "cheese, tomato, guacamole, sour cream",
                    "Gluten, Eggs, Milk","/img/nacho.jpg", true);
        Menu taco = new Menu(3, "Taco", 15f, 120, "beef, cheese, tomato",
                    "Gluten, Soy, Milk", "/img/taco.jpg", true);
        Menu quesadilla = new Menu(4, "Quesadilla", 13f, 80, "chicken, cheese",
                        "Gluten, Mustard, Milk", "/img/quesadilla.jpg", true);
        Menu fajita = new Menu(5, "Fajita", 14f, 80, "chicken, cheese, salad, sour cream",
                    "Gluten, Mustard, Milk", "/img/fajita.jpg", true );
        Menu enchilada = new Menu(6, "Enchilada", 12f, 80, "beef, cheese, salad",
                        "Gluten, Soy, Milk", "/img/enchiladas.jpg", true);

        menuRepository.save(burrito);
        menuRepository.save(nacho);
        menuRepository.save(taco);
        menuRepository.save(quesadilla);
        menuRepository.save(fajita);
        menuRepository.save(enchilada);
    }

    /**
     * Inserts user records into the database.
     */
    public void insertUserRecords() {
        User waiter1 = new User(1,"Waiter1", "waiter1", "WAITER");
        User waiter2 = new User(2,"Waiter2", "waiter2", "WAITER" );
        User waiter3 = new User(3,"Waiter3", "waiter3", "WAITER");
        User kitchen = new User(4,"Kitchen", "kitchen", "KITCHEN");

        userRepository.save(waiter1);
        userRepository.save(waiter2);
        userRepository.save(waiter3);
        userRepository.save(kitchen);

    }


}
