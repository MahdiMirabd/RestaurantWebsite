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
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "name", nullable = false) //
    private String name;

    /**
     * The price of a food item.
     */
    @Column(name = "price", nullable = false)
    private float price;

    /**\
     * The amount of calories in a food item.
     */
    @Column(name = "calories", nullable = false)
    private float calories;

    /**\
     * The list of toppings and extras on the meal.
     */
    @Column(name = "ingredients", nullable = false)
    private String ingredients;

    /**
     * The allergens contained in the meal.
     */
    @Column(name = "allergen")
    private String allergen;

    /**
     * A picture depicting the menu item.
     */
    @Column(name = "image")
    private String image;

}
