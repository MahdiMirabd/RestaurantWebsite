package uk.ac.rhul.cs2810.restaurantsystem.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "MessageTable")
@Table(name = "MessageTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tableNo", nullable = false)
    private int tableNo;
    
    @Column(name = "message", nullable = false)
    private String message;

   

    
}
