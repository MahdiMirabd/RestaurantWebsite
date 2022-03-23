package uk.ac.rhul.cs2810.restaurantsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The class from which the application is booted.
 */
@SpringBootApplication
public class RestaurantSystemApplication {
    /**
     * The main method which launches the application.
     *
     * @param args no arguments needs to be passed to the program
     */
    public static void main(String[] args) {
        SpringApplication.run(RestaurantSystemApplication.class, args);
    }

}
