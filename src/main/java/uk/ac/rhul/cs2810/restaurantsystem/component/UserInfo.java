package uk.ac.rhul.cs2810.restaurantsystem.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uk.ac.rhul.cs2810.restaurantsystem.model.User;
import uk.ac.rhul.cs2810.restaurantsystem.repository.UserRepository;


@Component
public class UserInfo implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        if(userRepository.count() == 0) {
            insertRecords();
        }

    }

    public void insertRecords() {
        User waiter1 = new User(1,"Waiter1", "waiter1", "WAITER", null );
        User waiter2 = new User(2,"Waiter2", "waiter2", "WAITER", null );
        User waiter3 = new User(3,"Waiter3", "waiter3", "WAITER", null );
        User kitchen = new User(4,"Kitchen", "kitchen", "KITCHEN", null );

        userRepository.save(waiter1);
        userRepository.save(waiter2);
        userRepository.save(waiter3);
        userRepository.save(kitchen);

    }
}
