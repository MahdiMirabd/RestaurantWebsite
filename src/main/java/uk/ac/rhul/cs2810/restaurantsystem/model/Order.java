package uk.ac.rhul.cs2810.restaurantsystem.model;

import java.util.ArrayList;
import uk.ac.rhul.cs2810.restaurantsystem.model.Menu;

import javax.persistence.Entity;

/**
 * Creates an object storing the details of the order
 * which is then passed on to the waiter to confirm.
 * 
 * @author Rayan
 */
public class Order {

    private static int orderNo = 0; // The id of the order
    private ArrayList<Menu> orderList; // The list of all the items that the customer ordered
    private float orderPrice; // The total price of all items the customer ordered

    public Order(){
        orderNo++;
        //orderList = ... get the list of objects from the item basket
        //orderPrice = ... get the total price of the objects in the item basket
    }
}
