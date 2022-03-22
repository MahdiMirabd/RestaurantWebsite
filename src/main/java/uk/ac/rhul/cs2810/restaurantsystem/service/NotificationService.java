package uk.ac.rhul.cs2810.restaurantsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.NotificationRepository;

import java.util.List;

/**
 * Interfaces with the notification Repository to fulfill
 * requests by the controller and return a response.
 */
@Service
public class NotificationService {
    /**
     * An instance of the notification repository.
     */
    @Autowired
    NotificationRepository notificationRepository;

    /**
     * Add a new notification in the database.
     *
     * @param message the notification message to be inserted
     * @param order the order the notification is concerning
     */
    public void insertNotification(String message, Order order) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setTableNo(order.getTableNo());
        notificationRepository.save(notification);
    }

    /**
     * Gets all notifications in the database.
     *
     * @return a list of all notifications
     */
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    /**
     * Gets the total number of notifications in the database
     *
     * @return the count of notifications
     */
    public Long getTotalNotifications() {
        return notificationRepository.count();
    }

    /**
     * Deletes a notification from the database.
     *
     * @param id the notification to be deleted
     */
    public void deleteNotification(Long id) {
        Notification notification = notificationRepository.getById(id);
        notificationRepository.delete(notification);
    }

    /**
     * Adds a client request to the database.
     *
     * @param message the client message to be added
     */
    public void addClientRequest(Notification message) {
        notificationRepository.save(message);
    }
}
