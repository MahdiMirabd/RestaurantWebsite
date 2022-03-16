package uk.ac.rhul.cs2810.restaurantsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.rhul.cs2810.restaurantsystem.model.Notification;
import uk.ac.rhul.cs2810.restaurantsystem.model.Order;
import uk.ac.rhul.cs2810.restaurantsystem.repository.NotificationRepository;

@Service
public class NotificationService {

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
        notification.setTableNo((int) order.getTableNo());
        notificationRepository.save(notification);
    }
}
