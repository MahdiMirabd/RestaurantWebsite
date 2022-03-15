package uk.ac.rhul.cs2810.restaurantsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.rhul.cs2810.restaurantsystem.model.Menu;
import uk.ac.rhul.cs2810.restaurantsystem.repository.MenuRepository;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> findItems(Boolean availability) {
        return menuRepository.findItems(availability);
    }
}
