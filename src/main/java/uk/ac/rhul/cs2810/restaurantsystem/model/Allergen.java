package uk.ac.rhul.cs2810.restaurantsystem.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "allergen")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Allergen {

    @Id
    private String name;

    @NonNull
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "allergens", cascade = CascadeType.ALL)  // the name of the set in the menu class
    private Set<Menu> menu = new HashSet<>();


}
