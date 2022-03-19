package uk.ac.rhul.cs2810.restaurantsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * A list of users and their roles.
 */
@Entity(name = "users")
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * The table's primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The staff username.
     */
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * The staff user password.
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * The staff role.
     */
    @Column(name = "role", nullable = false)
    private String role;

    /**
     * Session id
     */
    @Column(name = "session")
    private String session;
}
