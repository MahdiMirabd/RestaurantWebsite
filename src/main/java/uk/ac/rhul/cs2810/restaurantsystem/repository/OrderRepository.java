package uk.ac.rhul.cs2810.restaurantsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT order FROM orders  order WHERE order.status = :stat")
    List<Order> findConfirmedOrders(@Param("stat") String stat);


}
