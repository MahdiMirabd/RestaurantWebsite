package uk.ac.rhul.cs2810.restaurantsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.rhul.cs2810.restaurantsystem.model.User;
import uk.ac.rhul.cs2810.restaurantsystem.repository.UserRepository;

@Service
public class UserService {
    /**
     * An instance of the user repository.
     */
    @Autowired
    UserRepository userRepository;

    private String permissions = " ";

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {
        return this.permissions;
    }

    /**
     * Authenticates a user.
     *
     * @param user the user to be authenticated.
     * @return whether the user is valid or not.
     */
    public Boolean authenticate(User user) {
        User findUser = userRepository.findByUsername(user.getUsername());
        if (findUser == null) {
            return false;
        } else {
            String password = userRepository.findUserPassword(findUser.getUsername());
            if (password.equals(user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Gets the role of a user from the database.
     *
     * @param user the user whose role we need to retrieve
     * @return the users role
     */
    public String findUserRole(User user) {
        return userRepository.findByUsername(user.getUsername()).getRole();
    }
}
