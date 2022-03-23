package uk.ac.rhul.cs2810.restaurantsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
    List<Order> findOrderByStatus(@Param("stat") String stat);

    /**
     * Gets the table Number associated with an order.
     *
     * @param id the order to lookup
     * @return the table number of an order
     */
    @Query("SELECT order.tableNo FROM orders order WHERE order.id =:id")
    Order findTableNumber(@Param("id") Long id);

    /**
     * Computes the sum of all orders submitted by a specified table.
     *
     * @param tableNo the table number to lookup
     * @param stat the status of the order should be "delivered".
     * @return the total cost of orders by a specified table.
     */
    @Query("SELECT sum(m.price) FROM orders o, menu m WHERE o.tableNo =:tableNo and o.status =:stat and m.name = o.name ")
    public Float getTotalCost(@Param("tableNo") Long tableNo, @Param("stat") String stat);

    /**
     * Updates the status of an order from delivered to paid.
     *
     * @param tableNo the table number for which payment is maid
     * @param stat the status to be applied to the order in the database
     */
    @Transactional
    @Modifying
    @Query("UPDATE orders o SET o.status = :stat WHERE o.tableNo = :tableNo ")
    void updateOrderStatus(@Param("tableNo") long tableNo, @Param("stat") String stat);
}
