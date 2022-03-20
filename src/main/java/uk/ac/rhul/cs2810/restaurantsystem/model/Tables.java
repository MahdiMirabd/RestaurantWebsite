package uk.ac.rhul.cs2810.restaurantsystem.model;


/**
 * The number of tables available for seating in the restaurant.
 *
 * @author Hestre
 */

import lombok.*;

import javax.persistence.*;

@Entity(name = "tables")
@Table(name = "tables")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Tables {
    /**
     * The table's primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Conveys whether a table is available.
     */
    @Column(name = "available", nullable = false)
    private boolean available;

    @Column(name = "waiter", nullable = false)
    private String waiter;

}
