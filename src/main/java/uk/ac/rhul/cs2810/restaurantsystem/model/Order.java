package uk.ac.rhul.cs2810.restaurantsystem.model;

import java.util.ArrayList;

import lombok.*;
import uk.ac.rhul.cs2810.restaurantsystem.model.Menu;

import javax.persistence.*;

/**
 * Creates an object storing the details of the order
 * which is then passed on to the waiter to confirm.
 * 
 * @author Rayan
 */
@Entity
@Table(name = "order") // the name of the table in the database
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //auto increments the id in the database starting from 1
    private long id; // order number
    //private int orderNo = 0; // The id of the order
    private ArrayList<Menu> orderList; // The list of all the items that the customer ordered
    private float orderPrice; // The total price of all items the customer ordered

    //public Order(){
       // orderNo++;
        //orderList = ... get the list of objects from the item basket
        //orderPrice = ... get the total price of the objects in the item basket
   // }
}
