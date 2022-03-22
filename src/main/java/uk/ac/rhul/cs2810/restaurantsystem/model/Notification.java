package uk.ac.rhul.cs2810.restaurantsystem.model;

import lombok.*;

import javax.persistence.*;

/**
 * The Notification table in the database.
 * stores clients request for help.
 */
@Entity(name = "notification")
@Table(name = "notification")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notification {

    /**
     * The table's primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The Table requesting assistance.
     */
    @Column(name = "tableNo", nullable = false)
    private Long tableNo;

    /**
     * A generic message which will be sent to the waiter.
     */
    @Column(name = "message", nullable = false)
    private String message;
}
