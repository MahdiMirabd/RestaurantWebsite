package uk.ac.rhul.cs2810.restaurantsystem.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @NonNull
    @Column(name = "name") //
    private String name;

    /**
     * The price of a food item.
     */
    @NonNull
    @Column(name = "price")
    private float price;

    /**\
     * The amount of calories in a food item.
     */
    @NonNull
    @Column(name = "calories")
    private float calories;

    @NonNull
    @Column(name = "ingredients")
    private String ingredients;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "menu_allergen", joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "allergen_id"))
    private Set<Allergen> allergens = new HashSet<>();

}
