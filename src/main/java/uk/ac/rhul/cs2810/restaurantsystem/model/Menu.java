package uk.ac.rhul.cs2810.restaurantsystem.model;

import lombok.*;

import javax.persistence.*;

/**
 * The Menu table on the database.
 *
 * @author Hestre
 */
@Entity //signals that this class represents a table stored in the database.
@Table(name = "menu") // the name of the table in the database
@Getter
@Setter
@ToString
public class Menu {

    /**
     * The table's primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The name of a food item.
     */
    @Column(name = "name") //
    private String name;

    /**
     * The price of a food item.
     */
    @Column(name = "price")
    private float price;

    /**\
     * The amount of calories in a food item.
     */
    @Column(name = "calories")
    private float calories;

    /**
     * A no argument constructor.
     */
    public Menu() {
    }

    /**
     * Required argument constructor.
     *
     * @param id the table primary key
     * @param name of food item
     * @param price of food item
     * @param calories contained within food item
     */
    public Menu(long id, String name, float price, float calories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.calories = calories;
    }
}
