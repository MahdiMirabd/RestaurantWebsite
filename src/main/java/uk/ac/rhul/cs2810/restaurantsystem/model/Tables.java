package uk.ac.rhul.cs2810.restaurantsystem.model;

import lombok.*;

import javax.persistence.*;

/**
 * The number of tables available for seating in the restaurant.
 *
 * @author Hestre
 */
@Entity(name = "tables")
@Table(name = "tables")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tables {
    /**
     * The table's primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Conveys whether a table is available.
     */
    @Column(name = "available", nullable = false)
    private boolean available;
}
