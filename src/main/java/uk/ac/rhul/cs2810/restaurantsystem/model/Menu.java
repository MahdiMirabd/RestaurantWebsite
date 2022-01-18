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
// project lombok dependency will automatically create getters, setters, constructors, toString etc
@Getter @Setter @ToString @RequiredArgsConstructor @NoArgsConstructor
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
}
