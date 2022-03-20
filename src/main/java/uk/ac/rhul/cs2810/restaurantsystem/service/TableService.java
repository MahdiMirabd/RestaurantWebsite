package uk.ac.rhul.cs2810.restaurantsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.rhul.cs2810.restaurantsystem.model.Tables;
import uk.ac.rhul.cs2810.restaurantsystem.repository.TableRepository;

import java.util.List;

@Service
public class TableService {
    @Autowired
    TableRepository tableRepository;

    public List<Tables> findAvailableTable(Boolean available) {
        return tableRepository.findByAvailability(available);
    }
}
