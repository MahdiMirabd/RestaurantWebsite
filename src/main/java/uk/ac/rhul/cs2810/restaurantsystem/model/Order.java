package uk.ac.rhul.cs2810.restaurantsystem.model;

import lombok.*;

import javax.persistence.*;

/**
 * The order table in the database.
 * Stores customer orders.
 */
@Entity(name = "orders")
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Order {
    /**
     * The table's primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The table for which the order is placed.
     */
    @Column(name = "tableNo", nullable = false)
    private long tableNo;

    /**
     * The name of the menu item being ordered.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * The quantity of the menu item being ordered.
     */
    @Column(name = "quantity", nullable = false)
    private int quantity;

    /**
     * The current status of the order.
     * An order can have 1 of 4 status:
     * pending, confirmed, ready, delivered.
     */
    @Column(name = "status", nullable = false)
    private String status;
    
    /**
     * The time that the order was placed.
     * Only the hour and minute are shown.
     */
    @Column(name = "orderTime", nullable = false)
    private String orderTime;
}
