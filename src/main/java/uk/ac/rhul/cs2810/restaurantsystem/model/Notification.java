package uk.ac.rhul.cs2810.restaurantsystem.model;

import lombok.*;

import javax.persistence.*;

/**
 * The Alert table in the database.
 * stores clients request for help.
 */
@Entity(name = "notification")
@Table(name = "notification")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
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
    private int tableNo;

    /**
     * A generic message which will be sent to the waiter.
     */
    @Column(name = "message", nullable = false)
    private String message;

   

    
}
