package uk.ac.rhul.cs2810.restaurantsystem.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uk.ac.rhul.cs2810.restaurantsystem.model.Menu;
import uk.ac.rhul.cs2810.restaurantsystem.model.Tables;
import uk.ac.rhul.cs2810.restaurantsystem.repository.MenuRepository;
import uk.ac.rhul.cs2810.restaurantsystem.repository.TableRepository;

/**
 * Populates specified database tables automatically.
 */
@Component
public class DatabaseInfo implements CommandLineRunner {
    @Autowired
    TableRepository tableRepository;

    @Autowired
    MenuRepository menuRepository;

    @Override
    public void run(String... args) throws Exception {
        if(tableRepository.count() == 0) {
            insertTableRecords();
        }
        if(menuRepository.count() == 0) {
            insertMenuItems();
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
}
