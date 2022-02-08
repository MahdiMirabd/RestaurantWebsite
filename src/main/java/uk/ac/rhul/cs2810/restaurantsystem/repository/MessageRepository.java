package uk.ac.rhul.cs2810.restaurantsystem.repository;

import org.apache.logging.log4j.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.rhul.cs2810.restaurantsystem.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
