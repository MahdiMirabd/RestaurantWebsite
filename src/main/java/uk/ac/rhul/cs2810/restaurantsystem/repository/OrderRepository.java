package uk.ac.rhul.cs2810.restaurantsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;

import java.util.List;
/**
 * Provides the means for storing, retrieving,
 * searching, updating and deleting orders in the database.
 *
 * Order - the model name.
 * Long - the primary key of the table.
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * Finds all orders which has a particular status.
     *
     * @param stat can be either pending, confirmed, ready or delivered
     * @return orders with a particular status
     */
    @Query("SELECT order FROM orders  order WHERE order.status = :stat")
    List<Order> findOrders(@Param("stat") String stat);

    @Query("SELECT order.tableNo FROM orders order WHERE order.id =:id")
    List<Order>findTableNumber(@Param("id") Long id);


}
