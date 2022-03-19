package uk.ac.rhul.cs2810.restaurantsystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "users")
@Table(name = "users")
@Data
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
    @Column(name = "session", nullable = false)
    private String session;
}
