package uk.ac.rhul.cs2810.restaurantsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.rhul.cs2810.restaurantsystem.model.Allergen;

@Repository
public interface AllergenRepository extends JpaRepository<Allergen, String> {

}
